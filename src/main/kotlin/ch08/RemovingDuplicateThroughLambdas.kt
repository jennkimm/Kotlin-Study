package ch08

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

// STEP 1
// 윈도우 사용자의 평균 방문시간
val averageWindowsDuration = log
    .filter { it.os == OS.WINDOWS }
    .map(SiteVisit::duration)
    .average()

// STEP 2
// 만약 맥 사용자의 평균 방문시간을 구하고 싶다면? 위 코드와 중복되는 코드가 많을 것임.
// 중복 코드를 별도의 함수로 추출한다.
fun List<SiteVisit>.averageDurationFor(os: OS) =
    filter { it.os == os }.map(SiteVisit::duration).average()

// STEP 3
// 만약 모바일 사용자의 평균 방문시간을 구하고 싶다면?
// 더 복잡한 질의를 통해 방문 기록을 분석하고 싶다면?
// 고차 함수를 사용하여 중복 제거한다.
fun List<SiteVisit>.averageDurationFor2(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main(args: Array<String>) {
    println(averageWindowsDuration)
    println(log.averageDurationFor(OS.MAC))
    println(log.averageDurationFor2 { it.os == OS.IOS && it.path == "/signup" })
}