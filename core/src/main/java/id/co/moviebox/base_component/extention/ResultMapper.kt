package id.co.moviebox.base_component.extention

import id.co.moviebox.base_component.model.ResultDto
import id.co.moviebox.base_component.model.Result

inline fun <reified T> ResultDto<*>.toResult(data: T?): Result<T> {
    return Result(data, id, page, code)
}