import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PossibleRecipes {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = Arrays.stream(supplies).collect(Collectors.toSet());
        List<String> willAdd = Arrays.asList(recipes);

        int size = set.size();
        boolean change = true;
        Set<String> result = new HashSet<>();
        while (change) {
            for (int i = 0; i < willAdd.size(); i++) {
                if (set.containsAll(ingredients.get(i))) {
                    set.add(willAdd.get(i));
                    result.add(willAdd.get(i));
                }
            }

            change = (size != willAdd.size());
            size = willAdd.size();
        }

        return result.parallelStream().toList();
    }

    public static void main(String[] args) throws IOException {
        PossibleRecipes pr = new PossibleRecipes();

        List<List<String>> ing = new ArrayList<>();

        ing.add(Arrays.asList("mxf"));
        ing.add(Arrays.asList("iy","qxyj","nkov","qiabz","bec"));
        ing.add(Arrays.asList("nw","xutnl","e"));
        ing.add(Arrays.asList("eep","km","nw","xutnl","e","iy","vawos","qxyj","qiabz"));
        ing.add(Arrays.asList("nyhyc"));

        List<String> res = pr.findAllRecipes(new String[]{"qxyj","vawos","nkov","bec","qiabz"}
                    , ing
                    , new String[]{"nw","eep","iy","e","xutnl","km"});
        System.out.println(res.toString());

    }
}
