package main.java.com.company;

import com.company.SimilarWords;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimilarWordsTest {

    SimilarWords test = new SimilarWords();
    ArrayList array = new ArrayList();

    @org.junit.jupiter.api.Test
    void find_similar() {
        String str_test = ":краска";

        array.add("краска");
        array.add("ведро");

        String result = test.find_similar("краска", array);
        assertEquals(str_test, result);
        array.clear();
    }

    @org.junit.jupiter.api.Test
    void pairOfWords() {
        ArrayList chk = new ArrayList();
        chk.add("краска:краска");

        ArrayList firstArr = new ArrayList();
        ArrayList secondArr = new ArrayList();
        firstArr.add("краска");
        secondArr.add("краска");

        array = test.pairOfWords(firstArr, secondArr);

        assertEquals(chk, array);
        array.clear();


    }
}