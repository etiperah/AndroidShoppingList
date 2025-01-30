package com.example.mysecondapplication.Activities;

import com.example.mysecondapplication.R;
public class myData {
    static String[] nameArray = {
            "Cake Stand",
            "Measuring Spoons and Cups",
            "Piping Bags",
            "Piping Tips",
            "Rectangular Baking Pan",
            "Rolling Pin",
            "Round Baking Pan",
            "Baking Tools"
    };
    static String[] descriptionArray = {
            "The perfect way to display your cakes in style! Our sturdy and elegant cake stands are ideal for decorating and serving any occasion.",
            "Essential for precision in baking. Our high-quality measuring tools ensure your recipes turn out perfectly every time.",
            "Create beautiful decorations effortlessly with our durable and reusable piping bags, designed for professional results.",
            "Add a touch of creativity to your desserts with our variety of piping tips for unique and intricate designs.",
            "A versatile pan for baking cakes, brownies, or savory dishes, made with premium materials for even heat distribution.",
            "Roll out dough like a pro! Our rolling pins are crafted for comfort and control, making them a baker’s best friend.",
            "Bake perfect round cakes every time with our durable, non-stick round baking pans, designed for hassle-free baking.",
            "Discover all the essentials you need to make baking fun and easy with our wide range of high-quality baking tools."
    };
    static Integer[] drawableArray = {
            R.drawable.cakestand,
            R.drawable.measuringspoonsandcups,
            R.drawable.pipingbags,
            R.drawable.pipingtips,
            R.drawable.rectangularbakingpan,
            R.drawable.rollingpin,
            R.drawable.roundbakingpan,
            R.drawable.bakingtools
    };
    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7};
    static double[] priceArray = {
            29.99,   // Cake Stand
            12.50,   // Measuring Spoons and Cups
            15.75,   // Piping Bags
            10.00,   // Piping Tips
            20.00,   // Rectangular Baking Pan
            9.99,    // Rolling Pin
            18.50,   // Round Baking Pan
            25.00    // Baking Tools
    };

    public static String[] GetNameArray() {
        return nameArray;
    }

    public static String[] GetDescriptionArray() {
        return descriptionArray;
    }

    public static Integer[] GetDrawableArray() {
        return drawableArray;
    }

    public static Integer[] GetId() {
        return id_;
    }
    public static double[] GetPriceArray() {
        return priceArray;
    }
}
