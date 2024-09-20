-- ALTER TABLE users DROP FOREIGN KEY fk_status_id;
-- ALTER TABLE users DROP FOREIGN KEY fk_level_id;
-- ALTER TABLE users DROP FOREIGN KEY fk_organization_id;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS statuses;
DROP TABLE IF EXISTS levels;
DROP TABLE IF EXISTS company_member;
DROP TABLE IF EXISTS company;
CREATE TABLE company
(
    id               int          not null auto_increment primary key,
    name             varchar(50)  not null,
    business_license varchar(50)  not null unique,
    owner            varchar(50)  not null,
    address          varchar(100) not null,
    business_type    varchar(50)  not null,
    business_item    varchar(50)  not null,
    category         varchar(50)  not null,
    created_at       datetime     not null,
    updated_at       datetime     not null
);

CREATE TABLE company_member
(
    id         int          not null auto_increment primary key,
    company_id int          not null,
    name       varchar(50)  not null,
    title      varchar(50)  not null,
    email      varchar(50)  not null,
    address    varchar(100) not null,
    hphone     varchar(50)  not null,
    tel        varchar(50)  not null,
    fax        varchar(50)  not null,
    status     int          not null default  0,
    created_at datetime     not null,
    updated_at datetime     not null,
    INDEX      idx_company_id (company_id)
);

-- levels 테이블 생성
CREATE TABLE levels
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(100) NOT NULL,
    sort   INT          NOT NULL,
    status INT          NOT NULL DEFAULT 0
);

-- statuses 테이블 생성
CREATE TABLE statuses
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sort INT          NOT NULL
);

-- organizations 테이블 생성
CREATE TABLE organizations
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    depth     INT          NOT NULL DEFAULT 1,
    name      VARCHAR(100) NOT NULL,
    parent_id INT,
    sort      INT          NOT NULL DEFAULT 0,
    status    INT          NOT NULL DEFAULT 0,
    INDEX     idx_parent_id (parent_id)
);


-- users 테이블 생성
CREATE TABLE users
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(100) NOT NULL,
    name            VARCHAR(50)  NOT NULL,
    password        VARCHAR(255) NOT NULL,
    level_id        INT,
    status_id       INT,
    organization_id INT,
    CONSTRAINT fk_level_id FOREIGN KEY (level_id) REFERENCES levels (id),
    CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES statuses (id),
    CONSTRAINT fk_organization_id FOREIGN KEY (organization_id) REFERENCES organizations (id)
);

-- user_roles 테이블 생성
CREATE TABLE user_roles
(
    user_id INT,
    role    VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users (id)
);