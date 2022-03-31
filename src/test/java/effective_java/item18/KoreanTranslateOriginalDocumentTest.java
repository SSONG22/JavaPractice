package effective_java.item18;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KoreanTranslateOriginalDocumentTest {

    @Test
    void test(){
        OriginalDocument originalDocument = new KoreanTranslateOriginalDocument();
        assertThat(originalDocument.length()).isEqualTo(4);
    }

}