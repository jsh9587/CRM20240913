DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS levels;
DROP TABLE IF EXISTS statuses;
DROP TABLE IF EXISTS organizations;
CREATE TABLE levels
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name varchar(100) NOT NULL ,
    sort INT NOT NULL,
    status INT NOT NULL DEFAULT 0
);

CREATE TABLE statuses
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name varchar(100) NOT NULL ,
    sort INT NOT NULL
);

CREATE TABLE organizations
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    depth INT NOT NULL DEFAULT 1,
    name varchar(100) NOT NULL,
    parent_id INT NOT NULL DEFAULT 0 ,
    sort INT NOT NULL DEFAULT 0,
    status INT NOT NULL DEFAULT 0,
    INDEX idx_parent_id(parent_id)
);


CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    email    varchar(100) not null,
    name     VARCHAR(50)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    level_id INT,
    status_id INT,
    organization_id INT,
    roles VARCHAR(30) NOT NULL,
    -- Define the foreign key
    CONSTRAINT fk_level_id FOREIGN KEY (level_id) REFERENCES levels(id),
    CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES statuses(id),
    CONSTRAINT fk_organization_id FOREIGN KEY (organization_id) REFERENCES  organizations(id)
);

