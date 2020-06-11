package com.example.cooking_book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class RecipeList extends ListFragment {
    ArrayList<Food> arrayfood;

    Fadapter fa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arrayfood = new ArrayList<>();
        addf();
        fa = new Fadapter(getActivity(), R.layout.listdetail, arrayfood);
        setListAdapter(fa);
        return inflater.inflate(R.layout.recipe_list, container, false);

    }


    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        fooddata fooddt= (fooddata) getActivity();
        Food f1 = arrayfood.get(position);
        fooddt.sendfood(f1);
    }

    private void addf()
    {

        arrayfood.add(new Food("Spanish-Style Chicken and Rice","In this easy recipe for entertaining, crispy-skin chicken thighs roast atop a heady combo of Spanish-style rice emboldened with smoked paprika and mixed with earthy curly kale and sweet yellow bell peppers. Serve with a simple tossed salad to complete the meal.\n","Ingredients\n" +
                "Ingredient Checklist\n" +
                "1 1/2 teaspoons smoked paprika, divided\n" +
                "1/2 teaspoon garlic powder\n" +
                "1/4 teaspoon black pepper\n" +
                "4 (8 ounce) bone-in, skin-on chicken thighs\n" +
                "2 teaspoons olive oil\n" +
                "1/2 cup chopped green onions\n" +
                "1/2 large yellow bell pepper, cut into thin strips\n" +
                "4 cups loosely packed torn curly kale\n" +
                "1/2 cup unsalted chicken stock\n" +
                "1 (8.8 ounce) package UNCLE BEN\\'S\\® READY RICE\\® Spanish-Style Rice\n" +
                "1 tablespoon red wine vinegar\n" +
                "Salt to taste optional ","image"));
        arrayfood.add(new Food("Baked Overnight French Toast Casserole with Praline Topping","This is an easy, delicious, do-ahead baked casserole brunch recipe that doesnot need any syrup, since the French toast has its own praline topping. You can microwave the praline topping slightly to help spreadability\n","Ingredients\n" +
                "1 loaf French bread, cut into 1-inch slices\n" +
                "8 eggs\n" +
                "2 cups half-and-half\n" +
                "1 cup milk\n" +
                "2 tablespoons white sugar\n" +
                "1 teaspoon vanilla extract\n" +
                "1/2 teaspoon ground cinnamon\n" +
                "1/4 teaspoon ground nutmeg\n" +
                "1/4 teaspoon salt\n" +
                "Praline Topping:\n" +
                "1 cup butter, softened\n" +
                "1 cup packed brown sugar\n" +
                "1 cup chopped toasted pecans\n" +
                "2 teaspoons light corn syrup\n" +
                "1 teaspoon ground cinnamon\n" +
                "1/2 teaspoon ground nutmeg","image2"));
        arrayfood.add(new Food("Moist Baked Pork Chops","For perfectly prepared pork chops (preferably bone-in) you must brine them for at least 1 to 2 hours and pick chops that are at least 1/2 to 1-inch thick. The success to this dish is the brine for moistness. There are many brine variations out there for what flavor you are wanting to accomplish but, it is an important part of the overall dish. \n","Ingredients\n" +
                "Brine: \n" +
                "4 cups cold water \n" +
                "1/4 cup kosher salt \n" +
                "1 tablespoon whole black peppercorns \n" +
                "1 bay leaf \n" +
                "4 (5 ounce) center-cut pork chops on the bone \n" +
                "Rub: \n" +
                "1/2 cup packed brown sugar \n" +
                "1 teaspoon garlic powder \n" +
                "1 teaspoon paprika \n" +
                "1/2 teaspoon onion powder \n" +
                "1/2 teaspoon dry mustard powder \n" +
                "1/2 teaspoon kosher salt \n" +
                "1/4 teaspoon freshly ground black pepper \n" +
                "1 tablespoon olive oil, or more as needed \n" +
                "aluminum foil ","image3"));
        arrayfood.add(new Food("Vanilla Crepes","When I was a little girl, my mother would always make us crepes on Sundays. I also loved the smell of vanilla when my mother would make her cookies. So, I would always ask her to make her cookies, and when she refused, I would take out the vanilla and sit it next to me with the cap open, so that I could breathe the aroma. My mother get a kick out of this, and said, well, if it's that important, we'll add a little vanilla kick, just for you. After the first time she put the vanilla in, there was never a last...it became a tradition\n","Ingredients\n" +
                "1/2 cups milk\n" +
                "3 egg yolks\n" +
                "2 tablespoons vanilla extract\n" +
                "1 1/2 cups all-purpose flour\n" +
                "2 tablespoons sugar\n" +
                "1/2 teaspoon salt\n" +
                "5 tablespoons melted butter","image4"));
        arrayfood.add(new Food("Best Chocolate Chip Cookies","Crisp edges, chewy middles. ","Ingredients\n" +
                "1 cup butter, softened \n" +
                "1 cup white sugar \n" +
                "1 cup packed brown sugar \n" +
                "2 eggs \n" +
                "2 teaspoons vanilla extract \n" +
                "1 teaspoon baking soda \n" +
                "2 teaspoons hot water \n" +
                "1/2 teaspoon salt \n" +
                "3 cups all-purpose flour \n" +
                "2 cups semisweet chocolate chips \n" +
                "1 cup chopped walnuts ","image5"));
        arrayfood.add(new Food("Cake Mix Cinnamon Rolls","This recipe is absolutely delicious. I make them the night before, take them out in the morning and let them rise. I have also made sticky buns with this recipe using a coconut/pecan frosting for the bottom of my pan. \n","Ingredients\n" +
                "3 (.25 ounce) packages active dry yeast \n" +
                "2 ½ cups warm water \n" +
                "1 (18.25 ounce) package white cake mix \n" +
                "4 ½ cups all-purpose flour \n" +
                "1/2 cup butter, softened \n" +
                "1/2 cup brown sugar \n" +
                "2 teaspoons ground cinnamon \n" +
                "1/4 cup butter, melted \n" +
                "1/3 cup white sugar ","image6"));
        arrayfood.add(new Food("Churros ","These Mexican fritters are very common at fairs. In my border hometown, the line at this stand is always overwhelming. People wait hours in line just to get a taste of these churros. I have run across several recipes but this is the best one by far. \n","Ingredients\n" +
                "1 cup water \n" +
                "2 1/2 tablespoons white sugar \n" +
                "1/2 teaspoon salt \n" +
                "2 tablespoons vegetable oil \n" +
                "1 cup all-purpose flour \n" +
                "2 quarts oil for frying \n" +
                "1/2 cup white sugar, or to taste \n" +
                "1 teaspoon ground cinnamon ","image7"));
        arrayfood.add(new Food("Good Old Fashioned Pancakes","This is a great recipe that I found in my Grandma's recipe book. Judging from the weathered look of this recipe card, this was a family favorite.\n","Ingredients\n" +
                "1 1/2 cups all-purpose flour\n" +
                "3 1/2 teaspoons baking powder\n" +
                "1 teaspoon salt\n" +
                "1 tablespoon white sugar\n" +
                "1 1/4 cups milk\n" +
                "1 egg\n" +
                "3 tablespoons butter, melted","image8"));
        arrayfood.add(new Food("Baked Oatmeal II","Found this recipe in Pennsylvania Amish country. Everyone who tries it, loves it!","Ingredients\n" +
                "3 cups rolled oats\n" +
                "1 cup brown sugar\n" +
                "2 teaspoons ground cinnamon\n" +
                "2 teaspoons baking powder\n" +
                "1 teaspoon salt\n" +
                "1 cup milk\n" +
                "2 eggs\n" +
                "1/2 cup melted butter\n" +
                "2 teaspoons vanilla extract\n" +
                "3/4 cup dried cranberries","image9"));
        arrayfood.add(new Food("Best Potatoes You'll Ever Taste","Its time to release my potatoes to the world!!! Watch your guests try to guess what's in this delicious and simple recipe. It's the perfect side dish to any meal or BBQ, and a great way to dress up those darn potatoes! It's got me out of many a jam with entertaining. You cant go wrong. Since trying these, I have gone completely potato crazy with mad potato disease!!! Yum -- do it, mate! (Note: Only use real egg mayo - not the other kind.) \n","Ingredients\n" +
                "3 tablespoons mayonnaise \n" +
                "2 cloves garlic, crushed \n" +
                "1 teaspoon dried oregano \n" +
                "salt and pepper to taste \n" +
                "5 potatoes, quartered ","image10"));

    }

}
