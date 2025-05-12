import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.api.DiaryResponse
import com.example.practice.api.MelogApi
import com.example.practice.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {

    private val _diaryEmotions = MutableStateFlow<Map<LocalDate, Int>>(emptyMap())
    val diaryEmotions: StateFlow<Map<LocalDate, Int>> = _diaryEmotions

    fun loadDiaryEmotions(year: Int, month: Int) {
        viewModelScope.launch {
            val diaries = diaryRepository.getDiariesByMonth(year, month)
            val emotionsMap = diaries.associate {
                LocalDate.parse(it.created_at) to (it.emotiontype_id ?: -1)
            }
            _diaryEmotions.value = emotionsMap
        }
    }
}

class CalenderViewModel : ViewModel(){

}