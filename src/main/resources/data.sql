INSERT INTO levels (name,sort,status) values ('대표이사',1,0);
INSERT INTO levels (name,sort,status) values ('감사',2,0);
INSERT INTO levels (name,sort,status) values ('본부장',3,0);
INSERT INTO levels (name,sort,status) values ('팀장',4,0);
INSERT INTO levels (name,sort,status) values ('사원',5,0);

INSERT INTO statuses (name,sort) values ('재직',1);
INSERT INTO statuses (name,sort) values ('퇴직',2);
INSERT INTO statuses (name,sort) values ('휴직',3);


INSERT INTO organizations ( id, depth, name, parent_id, sort ) values( 1,1,'최상위',0 ,1 );
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


INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'drd7321@dailypharm.com','이정석','1234',1,1,1,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ojh001@dailypharm.com','오진희','1234',2,1,1,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'mimipapa@dailypharm.com','김민혁','1234',3,1,4,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'hjjung@dailypharm.com','정혜정','1234',4,1,7,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'onewayj1@dailypharm.com','한진주','1234',5,1,7,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'kjh@dailypharm.com','강주희','1234',5,1,7,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'dohee@dailypharm.com','오도희','1234',5,1,7,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'yjahn@dailypharm.com','안유진','1234',5,1,8,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ehdus1745@dailypharm.com','김도연','1234',5,1,8,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ksy1106@dailypharm.com','권성용','1234',4,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'deadu21@dailypharm.com','권세영','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'jyj@dailypharm.com','정윤지','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ssy@dailypharm.com','서승연','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'aram@dailypharm.com','최아람','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'kraken@dailypharm.com','윤진혁','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'mke@dailypharm.com','문경은','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'jsh9587@dailypharm.com','정승훈','1234',5,1,9,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'sjy4666@dailypharm.com','성진영','1234',5,1,9,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'pjh@dailypharm.com','박지호','1234',5,1,10,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'leejj@dailypharm.com','가인호','1234',3,1,5,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ksk@dailypharm.com','강신국','1234',4,1,11,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'bob83@dailypharm.com','김지은','1234',5,1,11,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'khk@dailypharm.com','강혜경','1234',5,1,11,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'jhj@dailypharm.com','정흥준','1234',5,1,11,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'hooggasi2@dailypharm.com','이탁순','1234',4,1,12,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'hgrace7@dailypharm.com','이혜경','1234',5,1,12,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'junghwanss@dailypharm.com','이정환','1234',5,1,12,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'sasiman@dailypharm.com','노병철','1234',4,1,13,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'unkindfish@dailypharm.com','어윤호','1234',5,1,13,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'wiviwivi@dailypharm.com','이석준','1234',5,1,13,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( '1000@dailypharm.com','천승현','1234',4,1,14,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'kjg@dailypharm.com','김진구','1234',5,1,14,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'shm@dailypharm.com','손형민','1234',5,1,14,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'lhs@dailypharm.com','이현수','1234',5,1,15,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'pjh@dailypharm.com','박지은','1234',5,1,15,'USER');


INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','안현정','1234',3,1,6,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','주다희','1234',4,1,16,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','이준명','1234',5,1,16,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','김언희','1234',5,1,16,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','성유경','1234',5,1,16,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','이경민','1234',5,1,16,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ahj@dailypharm.com','정현희','1234',5,1,16,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ljs08@dailypharm.com','이지선','1234',5,1,16,'USER');


INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'jskim@dailypharm.com','김재성','1234',3,1,17,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'seungohyou@dailypharm.com','유승오','1234',4,1,19,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ssm@dailypharm.com','심승민','1234',5,1,19,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'nhs@dailypharm.com','나현식','1234',5,1,19,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'shj@dailypharm.com','송호준','1234',5,1,19,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'leedh@dailypharm.com','이동현','1234',5,1,19,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'hjy@dailypharm.com','홍준영','1234',5,1,19,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'lbw@dailypharm.com','이배원','1234',5,1,20,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'jkj@dailypharm.com','정경재','1234',5,1,20,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'hazekm@dailypharm.com','송기만','1234',5,1,20,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'kimsung891@dailypharm.com','김성회','1234',5,1,20,'USER');


INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'sjpark@dailypharm.com','박상준','1234',3,1,18,'USER');

INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'sjpark@dailypharm.com','이지현','1234',4,1,21,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'ksj@dailypharm.com','김승직','1234',5,1,21,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'lsm@dailypharm.com','임수민','1234',5,1,21,'USER');


INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'enjoyjee@dailypharm.com','이인복','1234',4,1,22,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'medic@dailypharm.com','최선','1234',5,1,22,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'msh25800@dailypharm.com','문성호','1234',5,1,22,'USER');
INSERT INTO  users (email, name, password, level_id, status_id, organization_id,roles) values ( 'hskoo@dailypharm.com','허성규','1234',5,1,22,'USER');

