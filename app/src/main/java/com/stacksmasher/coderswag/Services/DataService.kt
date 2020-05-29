package com.stacksmasher.coderswag.Services

import com.stacksmasher.coderswag.Model.Category
import com.stacksmasher.coderswag.Model.Product

object DataService {
    val categories = listOf(
        Category("SHIRTS","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL","digitalgoodsimage")
    )

    val hats = listOf(
        Product("Devslopes Graphic Beanie", "$18", "hat01"),
        Product("Devslopes Hat Black", "$15", "hat02"),
        Product("Devslopes Hat White", "$15", "hat03"),
        Product("Devslopes Hat Snapback", "$22", "hat04")

    )

    val hoodies = listOf(
        Product("Devslopes Hoodie Gray", "$28", "hoodie01"),
        Product("Devslopes Hoodie Red", "$30", "hoodie02"),
        Product("Devslopes Hoodie Mix", "$28", "hoodie03"),
        Product("Devslopes Hoodie PureBlack", "$30", "hoodie04")
    )

    val shirts = listOf(
        Product("Devslopes Shirt Black", "$18", "shirt01"),
        Product("Devslopes Badge Light Gray", "$20", "shirt02"),
        Product("Devslopes Logo Shirt Red", "$22", "shirt03"),
        Product("Devslopes Hustle", "$30", "shirt04"),
        Product("Kickflip studios", "$18", "shirt05")
    )


}