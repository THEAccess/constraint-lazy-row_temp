package com.example.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp



@Composable
fun Test() {
    ConstraintLayout {
        val (image, row) = createRefs()
        createVerticalChain(image, row)
        ARow(modifier = Modifier.constrainAs(row) {
            start.linkTo(image.end)
            width = Dimension.fillToConstraints
        })

        AImage(modifier = Modifier.constrainAs(image) {
            top.linkTo(row.top)
            bottom.linkTo(row.bottom)
            height = Dimension.fillToConstraints
        })
    }
}


@Composable
fun AImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        bitmap = imageResource(id = R.drawable.sample_ic),
        )
}

@Composable
fun ARow(modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items((0..10).toList()) {
            Text(modifier = Modifier.padding(8.dp), text = "Item: $it")
        }
    }
}