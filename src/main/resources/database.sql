-- ��֪��mysql�Զ����ɵ�id��ʲô���ͣ�����ȫ���ַ��������������һ��
-- �༶

CREATE TABLE Class (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  class_num INT
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE Students (
  id   INT PRIMARY KEY       AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  sex  ENUM( 'MAN',
  'WOMAN'
) DEFAULT 'MAN',
  class_id VARCHAR (20
) REFERENCES CLASS (ID
)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- �û�
CREATE TABLE Users (
  id         INT PRIMARY KEY                             AUTO_INCREMENT,
  phone      VARCHAR(11) NOT NULL UNIQUE,
  passwd     VARCHAR(20) NOT NULL,
  users_name VARCHAR(20) NOT NULL,
  users_type ENUM( 'STUDENT',
  'HEAD_TEACHER',
  'TEACHER'
) DEFAULT 'STUDENT',
  access_token VARCHAR (200
),
  avatar_url VARCHAR (200
),
  background_url VARCHAR (200
),
  have_red_flower BOOLEAN DEFAULT FALSE
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE Moments (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  create_time  DATETIME     NOT NULL,
  poster_id    INT REFERENCES users (id),
  content      VARCHAR(200) NOT NULL,
  is_top       BOOLEAN DEFAULT FALSE,
  top_deadline DATETIME
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- �
CREATE TABLE Activities (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  poster_id   INT REFERENCES users (id),
  create_time DATETIME     NOT NULL,
  content     VARCHAR(200) NOT NULL
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- ��Դ
CREATE TABLE Source (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  surl         VARCHAR(200) NOT NULL,
  stype        INT,
  in_moment_id INT REFERENCES Moments (id)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- ����ǽ
CREATE TABLE Honor_Wall (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  users_id  INT REFERENCES users (id),
  moment_id INT REFERENCES Moments (id)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- �ղ�
CREATE TABLE Collections (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  users_id  VARCHAR(20) REFERENCES users (id),
  moment_id VARCHAR(20) REFERENCES Moments (id)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- ����
CREATE TABLE Comments (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  poster_id    INT REFERENCES users (id),
  reply_to     INT REFERENCES users (id),
  comment_time DATETIME     NOT NULL,
  content      VARCHAR(200) NOT NULL
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- ����
CREATE TABLE Favor (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  users_id  INT REFERENCES users (id),
  moment_id INT REFERENCES Moments (id)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- ��ʦ�û���༶��ϵ
CREATE TABLE RS_Teacher_Class (
  id              INT PRIMARY KEY AUTO_INCREMENT,
  users_id        INT REFERENCES users (id),
  class_id        INT REFERENCES Class (id),
  teacher_subject VARCHAR(20)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- �ҳ��û���ѧ����ϵ
CREATE TABLE RS_Parent_Student (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  users_id   INT REFERENCES users (id),
  student_id INT REFERENCES Students (id)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;

-- �û�-�
CREATE TABLE users_Activity (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  users_id    INT REFERENCES users (id),
  activity_id INT REFERENCES Activities (id)
)
  ENGINE = InnoDB
DEFAULT CHARSET = utf8;