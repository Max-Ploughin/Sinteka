package com.company;

import java.util.ArrayList;

// Класс для поиска схожих слов в двух разрезах
public class SimilarWords {

    // создаем структуры-шаблоны для хранения слов по раличным категориям
    private final String[] list_of_fasten = {"гвоздь", "шуруп", "дюбель", "саморез", "болт"};
    private final String[] list_of_colour = {"краска"};
    private final String[] list_of_containers = {"ведро", "корыто"};
    private final String[] list_of_materials = {"бетон", "цемент"};
    private final String[] list_of_other = {"доставка", "курьер"};

    // поиск похожего слова
    public String find_similar(String word, ArrayList secondRangeArray){

        if (chk_fasten(word)){
            return find_second_word(secondRangeArray, list_of_fasten);
        }
        if (chk_materials(word)){
            return find_second_word(secondRangeArray, list_of_materials);
        }
        if (chk_colour(word)){
            return find_second_word(secondRangeArray, list_of_colour);
        }
        if (chk_containers(word)){
            return find_second_word(secondRangeArray, list_of_containers);
        }
        if (chk_other(word)){
            return find_second_word(secondRangeArray, list_of_other);
        }
        return ": ?";

    }

    // метод для поиска слова в структурах-шаблонах
    private boolean chk_word (String[] array, String word){
        boolean result = false;

        for (int i = 0; i < array.length; i++) {

            if (word.toLowerCase().indexOf(array[i].toLowerCase()) > -1) {
                result = true;
                return result;
            } else {
                continue;
            }
        }
        return result;
    }

    // методы для поиска слова в структурах по категориям
    private boolean chk_fasten (String word) {
        return chk_word(list_of_fasten, word);
    }

    private boolean chk_colour (String word) {
        return chk_word(list_of_colour, word);
    }

    private boolean chk_containers (String word) {
        return chk_word(list_of_containers, word);
    }

    private boolean chk_materials (String word) {
        return chk_word(list_of_materials, word);
    }

    private boolean chk_other (String word) {
        return chk_word(list_of_other, word);
    }

    // метод для поиска второга слова. Если true, то возвращаем полученное слово
    private String find_second_word (ArrayList secondRangeArray, String[] pattern_array){
        for (int i=0; i < secondRangeArray.size(); i++){
            for (int y=0; y < pattern_array.length; y++){
                if (String.valueOf(secondRangeArray.get(i)).toLowerCase().indexOf(pattern_array[y].toLowerCase()) > -1){
                    String value = String.valueOf(secondRangeArray.get(i));
                    secondRangeArray.remove(y);
//                    return ":" + String.valueOf(secondRangeArray.get(i));
                    return ":" + value;
                }
            }
        }
        return ":?";
    }

    // метод для возвращения пары слов, которые находятся в одной категории структуры
    public ArrayList pairOfWords (ArrayList firstRange, ArrayList secondRange){
        ArrayList result = new ArrayList();
        for (int i=0; i < firstRange.size(); i++){
            String word1 = String.valueOf(firstRange.get(i));
            String word2 = find_similar(String.valueOf(firstRange.get(i)), secondRange);
            result.add(word1+word2);
        }
        return result;
    }

}
