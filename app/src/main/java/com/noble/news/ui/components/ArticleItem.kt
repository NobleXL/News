package com.noble.news.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.noble.news.model.entity.ArticleEntity

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/1 19:24
 *
 * 文章列表 item
 *
 * @param article
 * @param modifier
 */
@Composable
fun ArticleItem(article: ArticleEntity, loaded: Boolean, modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = article.title,
            color = Color(0xFF333333),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .placeholder(
                    visible = !loaded,
                    highlight = PlaceholderHighlight.shimmer(),
                    color = Color.LightGray
                )
        )

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "来源：${article.source}",
                color = Color(0xFF999999),
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .placeholder(
                        visible = !loaded,
                        highlight = PlaceholderHighlight.shimmer(),
                        color = Color.LightGray
                    )
            )

            Text(
                text = article.timestamp,
                color = Color(0xFF999999),
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .placeholder(
                        visible = !loaded,
                        highlight = PlaceholderHighlight.shimmer(),
                        color = Color.LightGray
                    )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider()
    }

}


