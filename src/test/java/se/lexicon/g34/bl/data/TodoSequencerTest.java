package se.lexicon.g34.bl.data;

import org.junit.Test;

public class TodoSequencerTest {
    @Test
    public void testNextTodoId() {
        TodoSequencer testTodoSeq= new TodoSequencer();
        for (int i = 0; i < 10; i++) {//Assign 10 Id
            System.out.println(testTodoSeq.nextTodoId());
        }
    }
    @Test
    public void test_reset(){
        TodoSequencer testPerSeq= new TodoSequencer();
        for (int i = 0; i < 10; i++) {//assign 10 Id
            if (i % 3 == 0) {//reset Id counter each 3rd >ID
                testPerSeq.reset();
            }
            System.out.println(testPerSeq.nextTodoId());
        }
    }
}
