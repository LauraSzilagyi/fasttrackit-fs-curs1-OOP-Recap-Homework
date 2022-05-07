package ro.fasttrackit.curs1.ex1;

import java.util.ArrayList;
import java.util.List;

import static ro.fasttrackit.curs1.ex1.Category.*;

public class ProjectMain {
    public static void main(String[] args) {
        List<Category> list = new ArrayList<>();
        list.add(CLOTHES);
        list.add(FOOD);
        list.add(ELECTRONICS);

        Project project = new Project("abc", 1300, list, "descriere");
        System.out.println(project);

        List<Category> categories = project.getCategories();
        categories.set(1, DYI);
        System.out.println(project);

        list.set(1, DYI);
        System.out.println(project);

        Project project1 = new Project("abc", -1, list, "descriere");
        System.out.println(project1);
    }
}
