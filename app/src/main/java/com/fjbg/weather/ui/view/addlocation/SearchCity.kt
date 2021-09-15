package com.fjbg.weather.ui.view.addlocation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjbg.weather.data.model.CityDto
import com.fjbg.weather.ui.viewmodel.WeatherViewModel
import com.fjbg.weather.util.getCountry

@Composable
fun SearchCityView(
    viewModel: WeatherViewModel?
) {
    SearchCity(viewModel)
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(12.dp)
    ) {

        viewModel?.getCityList()?.let { list ->
            items(count = list.size) {
                CityCountryText(
                    cityDto = list[it],
                    viewModel = viewModel
                )
            }
        }
    }
}


@Composable
fun SearchCity(viewModel: WeatherViewModel?) {
    val textState = remember { mutableStateOf("") }
    TextField(
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,//textColor(isSystemInDarkTheme()),
            backgroundColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = "Search",
                style = TextStyle(
                    color = Color.Gray//textColor(isSystemInDarkTheme())
                ),
            )
        },
        leadingIcon = {
            if (textState.value.isEmpty())
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search cities"
                )
        },
        trailingIcon = {
            if (textState.value.isNotEmpty())
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear search",
                    modifier = Modifier.clickable(onClick = {
                        textState.value = ""
                    })
                )
        },
        value = textState.value,
        onValueChange = {
            textState.value = it
            if (it.isNotEmpty() && it.length > 2) {
                viewModel?.searchCityByName(it)
            }
        },
        singleLine = true,
        maxLines = 1,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 28.dp,
                bottom = 16.dp
            )
    )
}

@Composable
fun CityCountryText(
    cityDto: CityDto,
    viewModel: WeatherViewModel?
) {
    Box(modifier = Modifier.clickable {
        viewModel?.saveCity(city = cityDto)
    }) {
        Text(
            text = "${cityDto.name}, ${cityDto.country.getCountry()}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 18.dp,
                    end = 18.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
        )
    }
}

@Preview
@Composable
fun SearchCityViewPreview() {
    SearchCityView(null)
}