package com.pbi.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.collection.ObjectList
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pbi.a30daysapp.data.FoodData
import com.pbi.a30daysapp.model.Food
import com.pbi.a30daysapp.ui.theme._30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodScreen()
                }
            }
        }
    }
}

@Composable
fun FoodScreen() {
    val foods = FoodData.foods

    Scaffold(
        topBar = { FoodTopAppBar() }
    ) {
        FoodList(
            foods = foods,
            paddingValues = it,
        )
    }
}

@Composable
fun FoodList(foods: ObjectList<Food>, paddingValues: PaddingValues, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = paddingValues,
        modifier = modifier
    ) {
        items(count = foods.size) {
            key(it) {
                FoodCard(
                    food = foods[it],
                    index = it)
            }
        }
    }
}

@Composable
fun FoodCard(food: Food, index: Int, modifier: Modifier = Modifier) {
    var visible by remember {
        mutableStateOf(false)
    }

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_medium),
                horizontal = dimensionResource(id = R.dimen.padding_large)
            )
            .clickable { visible = !visible }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    dimensionResource(id = R.dimen.padding_medium)
                )
        ) {
            DayLabel(index = index)

            FoodTitle(food = food)

            FoodImage(food = food)

            FoodDesc(food = food, visible = visible)
        }

    }
}

@Composable
fun DayLabel(modifier: Modifier = Modifier, index: Int) {
    Text(
        text = "Day ${index + 1}",
        style = MaterialTheme.typography.labelMedium,
        modifier = modifier
    )
}

@Composable
fun FoodTitle(food: Food, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = food.foodTitle),
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
            .padding(
                dimensionResource(id = R.dimen.padding_small)
            )
    )
}

@Composable
fun FoodDesc(food: Food, visible: Boolean, modifier: Modifier = Modifier) {
    AnimatedVisibility(visible = visible) {
        Text(
            text = stringResource(id = food.foodDesc),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier
                .padding(
                    dimensionResource(id = R.dimen.padding_small)
                )
        )
    }
}

@Composable
fun FoodImage(food: Food, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
    ) {
        Image(
            painter = painterResource(id = food.foodImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_title),
                style = MaterialTheme.typography.headlineMedium
            )
        },
        modifier = modifier
    )
}


@Preview(device = "spec:width=360dp,height=800dp", showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysAppTheme {
        FoodScreen()
    }
}