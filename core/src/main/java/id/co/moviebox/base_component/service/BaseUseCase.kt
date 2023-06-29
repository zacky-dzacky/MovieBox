package id.co.moviebox.base_component.service

import androidx.annotation.VisibleForTesting
import id.co.moviebox.base_component.extention.either
import id.co.moviebox.base_component.extention.toResult
import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.ui.StatefulResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.reflect.KFunction1

abstract class BaseUseCase<P, R> {
    abstract val default: R
    private var job: Job? = null

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    abstract suspend fun build(param: P): Result<R>

    fun execute(coroutineScope: CoroutineScope, param: P, onResult: KFunction1<StatefulResult<R?>, Unit>) {
        job = coroutineScope.launch {
            onResult(
                either {
                    build(param)
                }.toResult()
            )
        }
    }

    fun cancel() {
        job?.cancel()
    }
}