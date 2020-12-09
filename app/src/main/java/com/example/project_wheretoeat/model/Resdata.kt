package com.example.project_wheretoeat.model

data class Resdata (
    val current_page: Int,
    val per_page: Int,
    val restaurants: List<Restaurant>,
    val total_entries: Int
)