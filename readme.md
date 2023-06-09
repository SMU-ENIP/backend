Swagger API : Https://www.smu-enip.site/

## Architecture
![image](https://github.com/la1av1a/SMU-RecycleTrack-API/assets/81461486/beff7c08-3dfe-4d79-b193-2403dff79c86)


- [x] CI CD
    - [x] GithubActions를 이용한 CI 환경 구축
    - [x] GithubActions, dockerhub를 이용한 CD 환경 구축

- [x] Swagger
    - [x] Swaager를 통한 API문서 자동 완성 환경 구축

- [x] db
    - [x] Master-slave 시스템 환경 구축

- [x] SpringSecurity
    - [x] SpringSecurity를 이용한 인증 인가 환경 구축

- [x] 회원가입
    - [x] loginId,password,email로 회원가입
    - [x] 유저 정보 저장

- [x] 로그인
    - [x] KAKAO를 통한 Oauth 로그인
    - [x] loginId,password를 입력받아 로그인
    - [x] RDB와 비교하여 아이디 비밀번호 검증
    - [x] 토큰 생성
    - [x] Redis에 로그인된 유저 정보 저장

- [x] 영수증 업로드
    - [x] CLOVA API활용, 구매 목록 추출
    - [x] 유저가 업로드한 사진 S3에 업로드 후 url 취득
    - [x] 추출한 데이터와 사진URL 테이블에 저장

- [ ] 랭킹
    - [x] 유저 랭킹 API

