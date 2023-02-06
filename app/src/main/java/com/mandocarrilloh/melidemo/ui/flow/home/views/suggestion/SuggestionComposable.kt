package com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion

import android.annotation.SuppressLint
import android.view.KeyEvent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mandocarrilloh.domain.entity.SuggestionEntity
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.ui.composable.Screen

@ExperimentalFoundationApi
@Composable
fun SuggestionComposable(
    state: SuggestionState,
    handleEvent: (SuggestionEvent) -> Unit
) = Screen {
    Column {
        SuggestionToolbar(
            handleEvent
        )
        SuggestionContent(
            state.suggestion,
            handleEvent
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun SuggestionToolbar(
    handleEvent: (SuggestionEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.colorPrimary)),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        var query = rememberSaveable { mutableStateOf("") }
        var showClearIcon = remember { mutableStateOf(false) }
        val focusRequester = remember { FocusRequester() }

        OutlinedTextField(
            value = query.value,
            onValueChange = { onQueryChanged ->
                query.value = onQueryChanged
                if (onQueryChanged.isNotEmpty()) {
                    showClearIcon.value = true
                }
            },
            leadingIcon = {
                Image(
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search icon"
                )
            },
            trailingIcon = {
                if (showClearIcon.value) {
                    IconButton(onClick = {
                        val isCleaned = showClearIcon.value.not()
                        showClearIcon.value = isCleaned
                        if (!isCleaned) {
                            query.value = ""
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Clear,
                            tint = colorResource(id = R.color.colorGray),
                            contentDescription = "Clear icon"
                        )
                    }
                }
            },
            shape = RoundedCornerShape(12.dp),
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = colorResource(id = R.color.colorWhiteTransparent),
                focusedBorderColor = colorResource(id = R.color.colorWhiteTransparent),
                unfocusedBorderColor = colorResource(id = R.color.colorWhiteTransparent),
                cursorColor = colorResource(id = R.color.colorPrimary),
                placeholderColor = colorResource(id = R.color.colorGray),
            ),
            placeholder = { Text(text = stringResource(R.string.copy_search)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            keyboardActions = KeyboardActions(
                onDone = {
                    handleEvent(SuggestionEvent.SuggestionInput(query.value))
                    //focusRequester.requestFocus()
                }
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .onKeyEvent {
                    if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                        handleEvent(SuggestionEvent.SuggestionInput(query.value))
                        //focusRequester.requestFocus()
                        true
                    }
                    false
                }
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.colorWhite),
                    shape = RoundedCornerShape(12.dp)
                )
                .focusRequester(focusRequester)
        )
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun SuggestionContent(
    suggestions: List<SuggestionEntity>,
    handleEvent: (SuggestionEvent) -> Unit
) {
    if (suggestions.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                items = suggestions,
                key = SuggestionEntity::searchWord,
            ) { suggestion ->
                Suggestion(
                    suggestion = suggestion,
                    handleEvent = handleEvent,
                    modifier = Modifier.animateItemPlacement()
                )
            }
        }
    } else {
        Text(
            text = stringResource(id = R.string.empty_users),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2,
            color = colorResource(id = R.color.colorGray),
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
        )
    }
}

@Composable
private fun Suggestion(
    suggestion: SuggestionEntity,
    handleEvent: (SuggestionEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable { handleEvent(SuggestionEvent.SuggestionClicked(suggestion)) }
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Image(
            painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp, 32.dp)
        )
        Text(
            text = suggestion.searchWord,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )
    }
}
