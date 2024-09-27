# [DevFest Android in Korea 2024](https://festa.io/events/5968) 코루틴 방탈출 🔑

~마! 코루틴 좀 치나!~
아래의 가이드를 전부 **꼼꼼하게** 읽고, 문제를 풀어주세요. 🧩

## 목표 🎯

코루틴 방탈출은 `JUnit5` 기반 테스트 코드를 성공시키며 방을 탈출하는 이벤트입니다.

참가자들은 문제를 풀며 단서를 얻고 **최종 단계**를 풀면 방을 탈출할 수 있습니다.

## 프로젝트 세팅

- 본 저장소를 로컬에 clone합니다.
- IntelliJ IDEA를 활용하여 프로젝트를 엽니다.
- `src/test/kotlin/roomescape` 패키지 내의 파일을 열어서 `Run`을 클릭하여 테스트를 실행합니다.

## 문제 순서 📜

모든 문제는 순서대로 풀어주세요.

1. 연습 문제
   - [Step0.kt](src%2Ftest%2Fkotlin/roomescape/Step0.kt)
2. 본 문제
   - [Step1.kt](src%2Ftest%2Fkotlin/roomescape/Step1.kt)
   - [Step2.kt](src%2Ftest%2Fkotlin/roomescape/Step2.kt)
   - [Step3.kt](src%2Ftest%2Fkotlin/roomescape/Step3.kt)
   - [Step4.kt](src%2Ftest%2Fkotlin/roomescape/Step4.kt)
3. 최종 단계
   - [FinalStep.kt](src%2Ftest%2Fkotlin/roomescape/FinalStep.kt)

## 단서 얻는 방법 🕵️‍♂️

`Step1`부터 `Step4`까지의 모든 문제는 아래와 같이 **결과값(`expected`)** 을 예상하고, 실제 결과값을 비교합니다.

테스트가 성공할 수 있도록 결과값을 예상해보고, 해당 테스트가 성공한다면 **결과값(`expected`)** 을 최종 단계 단서로 활용하세요.

```kotlin
assertHashcode(actual, expected)
```
결과값 유출을 막기 위해 `hashCode()`를 사용하는 별도의 assertion을 활용합니다. **이 구문은 절대 수정하지 말아주세요**

## 최종 단계 🚪

위에서 얻은 단서(각 단계별 `expected`값)를 조합하여 최종 단계를 직접 나와서 풀어주세요.

## 탈출 조건 🔑

- 모든 문제를 풀고, 최종 단계 테스트 코드를 성공시키면 방을 탈출할 수 있습니다.
- 단서를 모두 모았고 최종 단계까지 완료했다면, 손을 들고 스태프에게 알려주세요.
- 1, 2등으로 문제를 풀어 방을 탈출한 참가자에게는 특별한 상품이 있을지도!? 🎁
- 최종 단계 이후에 보너스 하나라도 풀면 보너스 상품이 있을지도!?

## 주의사항 🚨

- `TODO` 주석이 있는 라인을 제외하고 테스트 코드를 수정하거나 삭제하지 마세요.
- `println` 등의 출력 구문이나 Debugger 등 문제의 답을 유추하는 방법을 사용할 수 없습니다.
- 인터넷 검색, ChatGPT, Gemini 등 AI 활용은 모두 금지됩니다.
- 문제를 풀기 위해 다른 참가자와 소통하거나, 외부의 도움을 받지 마세요.
- 문제의 답을 유출하지 말아 주세요.
