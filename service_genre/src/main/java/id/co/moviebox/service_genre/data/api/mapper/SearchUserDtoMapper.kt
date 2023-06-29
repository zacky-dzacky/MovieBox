package id.co.moviebox.service_genre.data.api.mapper

import id.co.moviebox.base_component.extention.toResult
import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.model.ResultDto
import id.co.moviebox.service_genre.data.api.dto.SearchUserDto
import id.co.moviebox.service_genre.domain.entity.SearchUser

class SearchUserDtoMapper {
    operator fun invoke(from: ResultDto<SearchUserDto>): Result<List<SearchUser>> {
        return from.toResult(from.items?.map {
            val data = it
            SearchUser(
                login = data.login,
                id = data.id,
                node_id = data.node_id,
                avatar_url = data.avatar_url,
                gravatar_id = data.gravatar_id,
                url = data.url,
                html_url = data.html_url,
                followers_url = data.followers_url,
                following_url = data.following_url,
                gists_url = data.gists_url,
                starred_url = data.starred_url,
                subscriptions_url = data.subscriptions_url,
                organizations_url = data.organizations_url,
                repos_url = data.repos_url,
                events_url = data.events_url,
                received_events_url = data.received_events_url,
                type = data.type,
                site_admin = data.site_admin,
                score = data.score,
            )
        })
    }
}