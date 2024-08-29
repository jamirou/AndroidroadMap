package com.example.exercisingjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview(showSystemUi = false)
@Composable
fun ConstraintLayoutGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val endGuide = createGuidelineFromEnd(0.3f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                end.linkTo(endGuide)
            }
        )
    }
}

//@Preview()
@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createBottomBarrier(boxRed, boxYellow)
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxYellow.bottom)
            }
        )
        Box(modifier = Modifier
            .size(325.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(barrier)
            }
        )
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
//                top.linkTo(boxGreen.bottom)
            }
        )
    }
}

@Preview
@Composable
fun ConstraintChain() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlack, boxWhite) = createRefs()
        createHorizontalChain(
            boxRed, boxBlack, boxWhite,
            chainStyle = ChainStyle.Packed
        )

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(parent.start)
                end.linkTo(boxBlack.start)
            }

        )
        Box(modifier = Modifier
            .size(115.dp)
            .background(Color.Black)
            .constrainAs(boxBlack) {
                start.linkTo(boxRed.end)
                end.linkTo(boxWhite.start)
            }

        )
        Box(modifier = Modifier
            .size(105.dp)
            .background(Color.White)
            .constrainAs(boxWhite) {
                start.linkTo(boxBlack.end)
                end.linkTo(parent.end)
            }

        )
    }
}