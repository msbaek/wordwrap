wordwrap
============

Clean Coders Episode 19 Advanced TDD Part 2 Examples

Getting Stuck

TDD를 어느 정도 해 봤다면 "getting stuck"을 경험해 봤을 것이다.

"getting stuck"은

- 현재 실패하고 있는 테스트를 성공시키기 위해 점진적(incremental)으로 할 수 있는 일이 없고
- 테스트를 성공시키기 위해서는 아주 많은 양의 프로덕션 코드를 작성해야 하고
- 극단의 경우 전체 알고리즘을 다시 작성해야만 

하는 경우를 일컫는 기술적 용어이다.

"getting stuck"은 문제의 징후로서 아래와 같은 경우에 발생한다.

- 잘못된 테스트를 작성했거나
- 프로덕션 코드를 너무 구체적(too specific not generic)하게 작성했거나
- 위의 두 문제를 모두 했거나

이 예제에서는 word wrap의 경우로 설명한다.
# 1. Test를 작성

```
public class WrapperTest {
    @Test
    public void nothing() {
    }
}
```

# 2. wrap("word word", 4)

## 2.1 add failing test

```
@Test public void
should_wrap() {
    assertThat(wrap("word word", 4), is("word\nword"));
}
```

## 2.2 make it pass

```
private String wrap(String s, int width) {
    return s.replaceAll(" ", "\n");
}
```
- with little golf game
- 최소한의 타이핑으로 성공하도록 한다.

# 3. wrap("a dog", 5)

## 3.1 add failing test

```
assertThat(wrap("a dog", 5), is("a dog"));
```

이 테스트를 추가하고 나니 뭘 해야 할지 바로 떠 오르지 않는다. 이때 조심해야 한다. **getting stuck**될 것 같기 때문이다.

## 3.2 make it pass

```
return s.length() > width ? s.replaceAll(" ", "\n") : s;
```

이렇게 함으로써 문제를 해결한 듯 하다.

근데 specific production code로 둘러 쌓였다. generalization factor를 잃었다. 만일 빨리 이 문제에서 back out(철회, 탈퇴, 취소)하지 않으면 우리는 상당히 stuck(꼼짝 달싹 못하다)하게 될 것이다.

# 4. wrap("a dog with a bone", 6)

## 4.1 add failing test

```
assertThat(wrap("a dog with a bone", 6), is("a dog\nwidth a\nbone"));
```

## 4.1 make it pass

어떻게 이 케이스를 패스시킬까 ?

이미 늦었다. 탈출이 불가능하다.

정말 stuck(꼼짝 달싹 못하는) 상태에 빠졌다.

이제 명확해 졌다. 이 테스트를 패스시키는 유일한 방법은 알고리즘을 다시 작성하는 것 뿐이다. 지금껏 작성한 모든 것을 버리고 처음부터 다시 작성해야 한다.

# 5. Getting Unstuck

- most degenerate test case를 먼저 작성하고
- 이 복잡함 퀴즈를 아주 작은 스텝씩 올라가자.
- 각 경우에서 해당 테스트를 통과시키도록 specific한 fix를 하는 것이 아니라 
- production code를 generalizing하여 테스트가 통과되도록 하자.

# 6. wrap(null, 1)

## 6.1 add failing test

```
assertThat(wrap(null, 1), is(""));
```

## 6.2 make it pass

`return null;` 대신 `return "";`로 테스트를 성공시킴

# 7. wrap(“”, 1)

## 7.2 add failing test

```
assertThat(wrap("", 1), is(""));
```