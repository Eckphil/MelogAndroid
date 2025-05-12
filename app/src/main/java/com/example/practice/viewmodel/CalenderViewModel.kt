import android.util.Log
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.api.DiaryResponse
import com.example.practice.api.MelogApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val api: MelogApi
) : ViewModel() {

    private val _diaryEmotions = mutableStateMapOf<LocalDate, Int>()
    val diaryEmotions: Map<LocalDate, Int> get() = _diaryEmotions

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun loadDiaryEmotions(year: Int, month: Int) {
        viewModelScope.launch {
            try {
                val response = api.getDiaryByDate(year, month)
                if (response.isSuccessful) {
                    response.body()?.forEach { diary ->
                        diary.created_at.let { dateStr ->
                            val date = LocalDate.parse(dateStr.substring(0, 10), dateFormatter)
                            val emotionId = diary.emotiontype_id
                            if (emotionId != null && emotionId in 0..7) {
                                _diaryEmotions[date] = emotionId
                            }
                        }
                    }
                } else {
                    Log.e("CalendarViewModel", "Failed to load diaries: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("CalendarViewModel", "Exception: ${e.message}")
            }
        }
    }
}

