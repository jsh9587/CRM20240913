INSERT INTO levels (name,sort,status) values ('대표이사',1,0);
INSERT INTO levels (name,sort,status) values ('감사',2,0);
INSERT INTO levels (name,sort,status) values ('본부장',3,0);
INSERT INTO levels (name,sort,status) values ('팀장',4,0);
INSERT INTO levels (name,sort,status) values ('사원',5,0);

INSERT INTO statuses (name,sort) values ('재직',1);
INSERT INTO statuses (name,sort) values ('퇴직',2);
INSERT INTO statuses (name,sort) values ('휴직',3);


INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 1,1,'최상위',NULL ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 2,2,'데일리팜',1 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 4,3,'경영지원본부',2 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 7,4,'회계관리팀',4 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 8,4,'광고기획팀',4 ,2 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 9,4,'IT디자인팀',4 ,3 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 10,4,'팜리쿠르트팀',4 ,4 );

INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 5,3,'취재보도본부',2 ,2 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 11,4,'약국경제팀',5 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 12,4,'의약정책팀',5 ,2 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 13,4,'제약바이오산업 1팀',5 ,3 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 14,4,'제약바이오산업 2팀',5 ,4);
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 15,4,'영상제작팀',5 ,5 );



INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 6,3,'OTC마케팅본부',2 ,3 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 16,4,'OTC마케팅팀',6 ,1 );



INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 3,2,'메디칼타임즈',1 ,2 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 17,3,'ETC마케팅본부',3 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 19,4,'ETC마케팅팀',17 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 20,4,'웨비나영상팀',17 ,2 );

INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 18,3,'취재보도본부',3 ,2 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 21,4,'의약/경제팀',18 ,1 );
INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 22,4,'의약/학술팀',18 ,2 );


INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'drd7321@dailypharm.com','이정석','1234',1,1,1);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ojh001@dailypharm.com','오진희','1234',2,1,1);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'mimipapa@dailypharm.com','김민혁','1234',3,1,4);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'hjjung@dailypharm.com','정혜정','1234',4,1,7);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'onewayj1@dailypharm.com','한진주','1234',5,1,7);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'kjh@dailypharm.com','강주희','1234',5,1,7);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'dohee@dailypharm.com','오도희','1234',5,1,7);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'yjahn@dailypharm.com','안유진','1234',5,1,8);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ehdus1745@dailypharm.com','김도연','1234',5,1,8);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ksy1106@dailypharm.com','권성용','1234',4,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'deadu21@dailypharm.com','권세영','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jyj@dailypharm.com','정윤지','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ssy@dailypharm.com','서승연','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'aram@dailypharm.com','최아람','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'kraken@dailypharm.com','윤진혁','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'mke@dailypharm.com','문경은','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jsh9587@dailypharm.com','정승훈','1234',5,1,9);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'sjy4666@dailypharm.com','성진영','1234',5,1,9);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'pjh@dailypharm.com','박지호','1234',5,1,10);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'leejj@dailypharm.com','가인호','1234',3,1,5);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ksk@dailypharm.com','강신국','1234',4,1,11);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'bob83@dailypharm.com','김지은','1234',5,1,11);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'khk@dailypharm.com','강혜경','1234',5,1,11);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jhj@dailypharm.com','정흥준','1234',5,1,11);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'hooggasi2@dailypharm.com','이탁순','1234',4,1,12);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'hgrace7@dailypharm.com','이혜경','1234',5,1,12);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'junghwanss@dailypharm.com','이정환','1234',5,1,12);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'sasiman@dailypharm.com','노병철','1234',4,1,13);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'unkindfish@dailypharm.com','어윤호','1234',5,1,13);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'wiviwivi@dailypharm.com','이석준','1234',5,1,13);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( '1000@dailypharm.com','천승현','1234',4,1,14);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'kjg@dailypharm.com','김진구','1234',5,1,14);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'shm@dailypharm.com','손형민','1234',5,1,14);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'lhs@dailypharm.com','이현수','1234',5,1,15);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'pjh@dailypharm.com','박지은','1234',5,1,15);


INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ahj@dailypharm.com','안현정','1234',3,1,6);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jdh@dailypharm.com','주다희','1234',4,1,16);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jmjm@dailypharm.com','이준명','1234',5,1,16);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'keh@dailypharm.com','김언희','1234',5,1,16);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'syk@dailypharm.com','성유경','1234',5,1,16);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'lkm@dailypharm.com','이경민','1234',5,1,16);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jhh@dailypharm.com','정현희','1234',5,1,16);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ljs08@dailypharm.com','이지선','1234',5,1,16);


INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jskim@dailypharm.com','김재성','1234',3,1,17);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'seungohyou@dailypharm.com','유승오','1234',4,1,19);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ssm@dailypharm.com','심승민','1234',5,1,19);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'nhs@dailypharm.com','나현식','1234',5,1,19);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'shj@dailypharm.com','송호준','1234',5,1,19);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'leedh@dailypharm.com','이동현','1234',5,1,19);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'hjy@dailypharm.com','홍준영','1234',5,1,19);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'lbw@dailypharm.com','이배원','1234',5,1,20);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'jkj@dailypharm.com','정경재','1234',5,1,20);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'hazekm@dailypharm.com','송기만','1234',5,1,20);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'kimsung891@dailypharm.com','김성회','1234',5,1,20);


INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'sjpark@dailypharm.com','박상준','1234',3,1,18);

INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'sjpark@dailypharm.com','이지현','1234',4,1,21);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'ksj@dailypharm.com','김승직','1234',5,1,21);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'lsm@dailypharm.com','임수민','1234',5,1,21);


INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'enjoyjee@dailypharm.com','이인복','1234',4,1,22);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'medic@dailypharm.com','최선','1234',5,1,22);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'msh25800@dailypharm.com','문성호','1234',5,1,22);
INSERT INTO  users (email, name, password, level_id, status_id, organization_id) values ( 'hskoo@dailypharm.com','허성규','1234',5,1,22);

INSERT INTO  user_roles( user_id, role) values
    (1, 'CEO'), --이정석
    (1, 'ROOT'), --이정석
    (2, 'AUDITOR'), --오진희
    (2, 'ROOT'), --오진희
    (3, 'DIRECTOR'), --김민혁
    (3, 'MANAGE'), --김민혁
    (4, 'TEAM_LEAD'), --정혜정
    (4, 'MANAGE'), --정혜정
    (5, 'USER'), --한진주
    (5, 'MANAGE'), --한진주
    (6, 'USER'), --강주희
    (6, 'MANAGE'), --강주희
    (7, 'USER'), --오도희
    (7, 'MANAGE'), --오도희
    (8, 'USER'), --안유진
    (8, 'MARKETING'), --안유진
    (9, 'USER'), --김도연
    (9, 'MARKETING'), --김도연
    (10, 'TEAM_LEAD'), --권성용
    (10, 'IT'), --권성용
    (11, 'USER'), --권세영
    (11, 'IT'), --권세영
    (12, 'USER'), --정윤지
    (12, 'IT'), --정윤지
    (13, 'USER'), --서승연
    (13, 'IT'), --서승연
    (14, 'USER'), --최아람
    (14, 'IT'), --최아람
    (15, 'USER'), --윤진혁
    (15, 'IT'), --윤진혁
    (16, 'USER'), --문경은
    (16, 'IT'), --문경은
    (17, 'USER'), --정승훈
    (17, 'IT'), --정승훈
    (18, 'USER'), --성진영
    (18, 'IT'), --성진영
    (19, 'USER'), --박지호
    (19, 'MANAGE'), --박지호

    (20, 'DIRECTOR'), --가인호
    (20, 'REPORTER'), --가인호
    (21, 'TEAM_LEAD'), --강신국
    (21, 'REPORTER'), --강신국
    (22, 'USER'), --김지은
    (22, 'REPORTER'), --김지은
    (23, 'USER'), --강혜경
    (23, 'REPORTER'), --강혜경
    (24, 'USER'), --정흥준
    (24, 'REPORTER'), --정흥준

    (25, 'TEAM_LEAD'), --이탁순
    (25, 'REPORTER'), --이탁순
    (26, 'USER'), --이혜경
    (26, 'REPORTER'), --이혜경
    (27, 'USER'), --이정환
    (27, 'REPORTER'), --이정환

    (28, 'TEAM_LEAD'), --노병철
    (28, 'REPORTER'), --노병철
    (29, 'USER'), --어윤호
    (29, 'REPORTER'), --어윤호
    (30, 'USER'), --이석준
    (30, 'REPORTER'), --이석준

    (31, 'TEAM_LEAD'), --천승현
    (31, 'REPORTER'), --천승현
    (32, 'USER'), --김진구
    (32, 'REPORTER'), --김진구
    (33, 'USER'), --손형민
    (33, 'REPORTER'), --손형민

    (34, 'USER'), --이현수
    (34, 'MANAGE'), --이현수
    (35, 'USER'), --박지은
    (35, 'MANAGE'), --박지은

    (36, 'DIRECTOR'), --안현정
    (36, 'MARKETING'), --안현정
    (37, 'TEAM_LEAD'), --주다희
    (37, 'MARKETING'), --주다희
    (38, 'USER'), --이준명
    (38, 'MARKETING'), --이준명
    (39, 'USER'), --김언희
    (39, 'MARKETING'), --김언희
    (40, 'USER'), --성유경
    (40, 'MARKETING'), --성유경
    (41, 'USER'), --이경민
    (41, 'MARKETING'), --이경민
    (42, 'USER'), --정현희
    (42, 'MARKETING'), --정현희
    (43, 'USER'), --이지선
    (43, 'MARKETING'), --이지선


    (44, 'DIRECTOR'), --김재성
    (44, 'MARKETING'), --김재성
    (45, 'TEAM_LEAD'), --유승오
    (45, 'MARKETING'), --유승오
    (46, 'USER'), --심승민
    (46, 'MARKETING'), --심승민
    (47, 'USER'), --나현식
    (47, 'MARKETING'), --나현식
    (48, 'USER'), --송호준
    (48, 'MARKETING'), --송호준
    (49, 'USER'), --이동현
    (49, 'MARKETING'), --이동현
    (50, 'USER'), --홍준영
    (50, 'MARKETING'), --홍준영
    (51, 'USER'), --이배원
    (51, 'MARKETING'), --이배원
    (52, 'USER'), --정경재
    (52, 'MARKETING'), --정경재
    (53, 'USER'), --송기만
    (53, 'MARKETING'), --송기만
    (54, 'USER'), --김성회
    (54, 'MARKETING'), --김성회

    (55, 'DIRECTOR'), --박상준
    (55, 'REPORTER'), --박상준

    (56, 'TEAM_LEAD'), --이지현
    (56, 'MARKETING'), --이지현
    (57, 'USER'), --김승직
    (57, 'MARKETING'), --김승직
    (58, 'USER'), --임수민
    (58, 'MARKETING'), --임수민

    (59, 'TEAM_LEAD'), --이인복
    (59, 'MARKETING'), --이인복
    (60, 'USER'), --최선
    (60, 'MARKETING'), --최선
    (61, 'USER'), --문성호
    (61, 'MARKETING'), --문성호
    (62, 'USER'), --허성규
    (62, 'MARKETING');--허성규
