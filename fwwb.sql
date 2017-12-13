-- 不知道mysql自动生成的id是什么类型，这里全当字符串处理，有问题改一下
-- 班级

CREATE TABLE School (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  school_name VARCHAR(50) NOT NULL,
  description VARCHAR(200)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE Class (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  class_num   INT         NOT NULL,
  class_name  VARCHAR(20) NOT NULL,
  school_id   INT,
  description VARCHAR(200),

  FOREIGN KEY (school_id) REFERENCES School (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 用户
CREATE TABLE Users (
  id              INT PRIMARY KEY                             AUTO_INCREMENT,
  phone           VARCHAR(11) NOT NULL UNIQUE,
  passwd          VARCHAR(20) NOT NULL,
  users_name      VARCHAR(20) NOT NULL,
  users_type      ENUM ('PARENT', 'HEAD_TEACHER', 'TEACHER')  DEFAULT 'PARENT',
  class_id        INT,
  access_token    VARCHAR(200),
  avatar_url      VARCHAR(200),
  background_url  VARCHAR(200),
  have_red_flower BOOLEAN                                     DEFAULT FALSE,

  FOREIGN KEY (class_id) REFERENCES Class (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE Students (
  id          INT PRIMARY KEY       AUTO_INCREMENT,
  name        VARCHAR(20) NOT NULL,
  student_num INT         NOT NULL,
  sex         ENUM ('MAN', 'WOMAN') DEFAULT 'MAN',
  parent_id   INT,
  class_id    INT,
  school_id   INT,

  FOREIGN KEY (parent_id) REFERENCES Users (id),
  FOREIGN KEY (class_id) REFERENCES Class (id),
  FOREIGN KEY (school_id) REFERENCES School (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE Teachers (
  id           INT PRIMARY KEY                  AUTO_INCREMENT,
  teacher_num  INT NOT NULL,
  teacher_type ENUM ('TEACHER', 'HEAD_TEACHER') DEFAULT 'TEACHER',
  class_id     INT,
  user_id      INT,

  FOREIGN KEY (class_id) REFERENCES Class (id),
  FOREIGN KEY (user_id) REFERENCES Users (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE Moments (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  create_time  DATETIME     NOT NULL,
  poster_id    INT,
  class_id     INT,
  content      VARCHAR(200) NOT NULL,
  is_top       BOOLEAN         DEFAULT FALSE,
  top_deadline DATETIME,

  FOREIGN KEY (poster_id) REFERENCES Users (id),
  FOREIGN KEY (class_id) REFERENCES Class (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 活动
CREATE TABLE Activities (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  poster_id   INT,
  create_time DATETIME     NOT NULL,
  content     VARCHAR(200) NOT NULL,
  class_id    INT,

  FOREIGN KEY (poster_id) REFERENCES Users (id),
  FOREIGN KEY (class_id) REFERENCES Class(id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 资源
CREATE TABLE Source (
  id           INT PRIMARY KEY                AUTO_INCREMENT,
  surl         VARCHAR(200) NOT NULL,
  stype        ENUM ('PIC', 'VIDEO', 'VOICE') DEFAULT 'PIC',
  in_moment_id INT,

  FOREIGN KEY (in_moment_id) REFERENCES Moments (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 荣誉墙
CREATE TABLE Honor_Wall (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  users_id  INT,
  moment_id INT,

  FOREIGN KEY (users_id) REFERENCES Users (id),
  FOREIGN KEY (moment_id) REFERENCES Moments (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 收藏
CREATE TABLE Collections (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  users_id  INT,
  moment_id INT,
  create_at DATETIME,

  FOREIGN KEY (users_id) REFERENCES Users (id),
  FOREIGN KEY (moment_id) REFERENCES Moments (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 评论
CREATE TABLE Comments (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  poster_id    INT,
  reply_to     INT,
  moment_id    INT,
  comment_time DATETIME     NOT NULL,
  content      VARCHAR(200) NOT NULL,

  FOREIGN KEY (moment_id) REFERENCES Moments (id),
  FOREIGN KEY (poster_id) REFERENCES Users (id),
  FOREIGN KEY (reply_to) REFERENCES Users (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 点赞
CREATE TABLE Favor (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  users_id  INT,
  moment_id INT,
  create_at DATETIME NOT NULL,
  moment_user_id INT,

  FOREIGN KEY (users_id) REFERENCES Users (id),
  FOREIGN KEY (moment_id) REFERENCES Moments (id),
  FOREIGN KEY (moment_user_id) REFERENCES Users(id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 用户-活动
CREATE TABLE users_Activity (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  users_id    INT REFERENCES users (id),
  activity_id INT REFERENCES Activities (id),

  FOREIGN KEY (users_id) REFERENCES Users (id),
  FOREIGN KEY (activity_id) REFERENCES Activities (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
