package com.chillyroom.z.white

data class Card(val identifier: Int,
                var isFaceUp: Boolean = false,
                var isMatched: Boolean = false)