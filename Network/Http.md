HTTP에 대해 공부하기에 앞서 인터넷이 무엇인지 확실히 하고가보자.
# 인터넷(Internet)이란
> TCP/IP 기반의 네트워크가 전세계적으로 확대되어 하나로 연결된 네트워크(네트워크들의 결합체) 이다.
> 인터넷 기반의 대표적인 서비스가 www이다.
 - 인터넷 기반의 서비스들 예시
 
|이름|프로토콜|포트|기능|
|------|---|---|---|
|www|HTTP|80|웹 서비스|
|Email|SMTP/POP3/IMAP|25/110/114|이메일 서비스|
|FTP|fTP|21|파일 전송 서비스|
|DNS|TCP/UDP|53|네임 서비스|
|NEWS|NNTP|119|인터넷 뉴스 서비스|

- 물리적인 하나의 컴퓨터에는 여러 개의 서비스가 동작할수 있다.
  -> 각각의 서버는 Port라는 값으로 구분돼서 동작한다.
- IP 주소와 Port번호의 개념
  * IP 주소 또는 도메인 이름
      1. 하드웨어 서버를 찾기 위해 반드시 필요한 정보
  * Port 번호
      1. 해당 물리적인 컴퓨터 안에 존재하는 소프트웨어 서버를 찾기 위한 정보
      2. 하나의 물리적인 컴퓨터에는 여러 개의 소프트웨어 프로그램이 각각의 Socket을 사용하여 데이터 통신을 하고 있기 때문에 각각의 Socket을 구분할 필요가 있다. 이 때 Port번호를 통해 구분한다.
      3. 0 보다 큰 숫자로 구성되어 있다.
      
-----------

# HTTP란 (HyperText Transfer Protocol)
> Http는 인터넷 상에서 클라이언트와 서버가 데이터를 주고받기 위한 프로토콜을 말한다.
> 현재 계속 발전하여 HTTP/2 까지 버전이 등장한 상태이다.

1. 클라이언트
  : Http를 통해 서버로 데이터를 요청하는 요청자이며 크롬, IE, 사파리 등의 웹 브라우저가 그 역할을 한다.
  응용 프로그램에서는 Http 요청을 위해 사용하는 라이브러리가 그 역할을 한다.
2. 서버
  : 클라이언트가 요청한 데이터를 반환해주는 제공자이며 이미지, HTML파일처럼 파일을 제공하는 서버,
  요청 주소에 따라 다른 내용을 제공하는 API서버 등 다양하게 있다. Http 통신에서는 서버가 제공하는 결과를 응답이라고 한다.
  
## HTTP와 HTTPS의 차이
1. HTTP
  - 웹상에서 클라이언트와 서버간에 요청/응답으로 정보를 주고 받을수 있는 프로토콜

2. HTTPS
  - 웹 통신 프로토콜인 HTTP에서 보안이 강화된 버전이다.
  - HTTPS는 소켓 통신에서 일반 텍스트를 이용하는 대신에, SSL이나 TLS 프로토콜을 통해 세션 데이터를 암호화한다.


## HTTP 통신 과정
* HTTP는 서버/클라이언트 모델을 따른다.
  - 클라이언트 -> 요청 -> 서버 -> 응답 -> 클라이언트
  
* 특징
  - 비연결지향(Connectionless) : 클라이언트가 request를 서버에 보내고, 서버가 클라이언트 요청에 맞는 response를 보내면 바로 연결을 끊는다.
  - 무상태(Stateless) : 연결을 끊는 순간 클라이언트와 서버의 통신은 끝나며 상태 정보를 유지하지 않는다.

* 단점
  - 연결을 끊어버리기 때문에 클라이언트의 이전 상황을 알 수 없다. -> 이러한 특징 때문에 정보를 유지하기 위해 Cookie와 같은 기술이 등장하게 되었다.
  - 
  
## HTTP 메시지 구조

### HTTP 요청 메시지 형식
> HTTP Request Message = Request Header + 빈 줄 + Request Body
* Header
  1. 첫 번째 줄(start-line)
    - 요청 메소드 + 요청 URI + HTTP 프로토콜 버전 ( GET / background.png HTTP / 1.0) (POST / HTTP 1.1)
  2. 두 번째 줄 ~ (HTTP headers)
    - Header 정보들 ('Header Name: Header Value' 형태)
    - 각 줄은 Line Feed(LF) 와 Carriage Return(CR)으로 구분된다.
 
 * 빈 줄(empty-line)
   - 요청에 대한 모든 메타 정보가 전송되었음을 알린다.

 * Body
   - POST, PUT의 경우에만 존재한다.
   - 요청과 관련된 내용 (HTML 폼 콘텐츠 등) 

### HTTP 응답 메시지 형식
> HTTP Response Message = Response Header + 빈 줄 + Response Body

* Header
 1. 첫 번째 줄 (status-line)
   - HTTP 프로토콜 버전 + 응답 코드 + 응답 메시지 (HTTP/1.1 404 Not Found.)
 2. 두 번째 줄 ~ (HTTP Headers)
   - Header 정보들 ('Header Name: Header Value' 형태) => 날짜, 웹서버 이름, 웹서버 버전, 콘텐츠 타입, 콘텐츠 길이, 캐시 제어 방식 등
   - 각 줄은 Line Feed(LF)와 Carriage Return(CR) 으로 구분된다.

 * 빈 줄(empty-line)
   - 요청에 대한 모든 메타 정보가 전송되었음을 알린다.

 * Body
   - 실제 응답 리소스 데이터
   - 201, 204와 같은 상태 코드를 가진 응답에는 보통 body

https://gmlwjd9405.github.io/2019/04/17/what-is-http-protocol.html


------

* Header
1. General Header : 요청과 응답 모두 공통으로 들어가는 Header를 의미한다.
  -> Date (Http 메시지 생성 시간), Connection (서버와 클라이언트의 연결옵션), Via (메시지가 어느 중개자를 거쳐서 왔는지),
     Tran
