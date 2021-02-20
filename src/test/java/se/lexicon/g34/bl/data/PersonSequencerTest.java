package se.lexicon.g34.bl.data;

import org.junit.Test;

public class PersonSequencerTest {
    @Test
    public void testNextPersonId() {
        PersonSequencer testPerSeq= new PersonSequencer();
        for (int i = 0; i < 10; i++) {//Assign 10 Id
            System.out.println(testPerSeq.nextPersonId());
        }
    }
    @Test
    public void test_reset(){
        PersonSequencer testPerSeq= new PersonSequencer();
        for (int i = 0; i < 10; i++) {//assign 10 Id
            if (i % 3 == 0) {//reset Id counter each 3rd >ID
                testPerSeq.reset();
            }
            System.out.println(testPerSeq.nextPersonId());
        }
    }
}
