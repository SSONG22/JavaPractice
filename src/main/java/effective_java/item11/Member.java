package effective_java.item11;

import java.util.Objects;

public class Member {
    private String name;
    private String gender;
    private String age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) &&
                Objects.equals(gender, member.gender) &&
                Objects.equals(age, member.age);
    }

    @Override
    public int hashCode() {
        // 1
        int result = name.hashCode(); // String 타입의 hashCode
        // 2
        result = 31 * result + gender.hashCode();
        result = 31 * result + age.hashCode();
        System.out.println("좋은 해시코드 구현 방법 : "+result+"  Object의 hash : "+ Objects.hash(name, gender, age));
        return result;
    }

    Member(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
