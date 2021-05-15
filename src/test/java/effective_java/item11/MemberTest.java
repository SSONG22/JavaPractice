package effective_java.item11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @DisplayName("hashCode 에 대해 알아보기")
    @Test
    void jessi의_hashCode(){
        Member jessi = new Member("Jessi", "woman", "22");
        Member john = new Member("John", "man", "22");
        Member jessi2 = jessi; // 같은 객체
        System.out.println(jessi.getName() + "의 hashCode" + jessi.hashCode());
        System.out.println(john.getName() + "의 hashCode" + john.hashCode());
        System.out.println(jessi.hashCode()+" "+jessi2.hashCode()+" 비교");
        assertEquals(jessi.hashCode(), jessi2.hashCode());
    }

    @DisplayName("hashCode 만들기")
    @Test
    void hashCode_테스트(){
        Member jessi = new Member("Jessi", "woman", "22");
        Member jessiCopy = new Member("Jessi", "woman", "22");
        Member john = new Member("John", "man", "22");
        assertNotEquals(jessi.hashCode(), john.hashCode());
        assertEquals(jessi.hashCode(), jessiCopy.hashCode());
    }
}