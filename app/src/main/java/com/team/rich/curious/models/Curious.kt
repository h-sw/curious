package com.team.rich.curious.models
/**
 * @author hanseungwoo
 *
 * -definition.
 *   어플의 핵심이 되는 데이터 클래스.
 *   현재 내가 궁금해서 지속적으로 하고 있는 한가지 행위를 나타내는 객체를
 *   "Curious" 라고 정의
 *
 *   Curious 는 어떠한 행위를 지속적으로 할 수 있도록 가이드 역할도 할 수 있으며,
 *   어떠한 행위를 위한 커리큘럼이 될 수도 있다.
 *
 *
 * ex) 우리가 "5분 리프팅 마사지"를 통해 얻을 수 있는 효과를 알고 싶다.
 *  -> 5분 리프팅 마사지 Curious.
 *
 * User 한 명은 여러개의 Curious를 소유할 수 있다.
 *
 *
 * -parameter
 *   @param name : Curious의 이름.
 *   @param srcUrl : 원본이 되는 동영상 주소 : Youtube
 *   @param contentsProvider : 컨텐츠 제공자.
 *   @param repeatDay : 컨텐츠를 진행한 일 수
 *   @param recommendDay : 컨텐츠 권장 시행 일 수
 *   @param recommendTime : 컨텐츠 시행 시간
 *
 *
 *
 * -updates
 *  - proto-type : 현재 이름정보만 넣어놓은 상태.
 *  - 여러가지 정보를 담거나 연결할 수 있도록 객체를 디자인 할 필요가 있음.
 *  - 최대한 추상화하여 추 후 유지보수를 쉽게 할 수 있도록 설계 할 것.
 * */
class Curious (
    var name                : String?,
    var srcUrl              : String?,
    var contentsProvider    : Provider,
    var likes               : Int,
    var repeatDay           : Int,
    var recommendDay        : Int,
    var repeatTime          : Int,
    var recommendTime       : Int
)