-- TB_TODO 테이블 생성 --

CREATE TABLE TB_TODO(

	TODO_NO 			NUMBER CONSTRAINT TB_TODO_PK PRIMARY KEY,
	TODO_TITLE 		VARCHAR2(50) NOT NULL,
	TODO_CONTENT 	VARCHAR2(4000) NOT NULL,
	COMPLETE 			CHAR(1) DEFAULT 'N' 
								CONSTRAINT COMPLETE_YN CHECK( COMPLETE IN ('Y', 'N') ),
	REG_DATE		 	DATE DEFAULT SYSDATE 

);

COMMENT ON COLUMN TB_TODO.TODO_NO 			IS '할 일 번호';
COMMENT ON COLUMN TB_TODO.TODO_TITLE 		IS '할 일 제목';
COMMENT ON COLUMN TB_TODO.TODO_CONTENT 	IS '할 일 내용';
COMMENT ON COLUMN TB_TODO.COMPLETE 			IS '할 일 완료여부(Y/N)';
COMMENT ON COLUMN TB_TODO.REG_DATE 			IS '할 일 등록일';

-- 할 일 번호(TODO_NO) 번호생성기 (SEQUENCE) 만들기

CREATE SEQUENCE SEQ_TODO_NO NOCACHE; 
-- CACHE : 20개씩 숫자를 미리 만들어 놓는다
-- 				 PC 종료 후 만든 숫자는 버리고 재사용 안함.. 
-- NOCACHE : 캐시를 안한다

-- 샘플 데이터 추가
INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, '테스트 제목1', '테스트 내용1', DEFAULT, DEFAULT);

INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, '테스트 제목2', '테스트 내용1', DEFAULT, DEFAULT);

INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, '테스트 제목3', '테스트 내용1', DEFAULT, DEFAULT);

SELECT *
FROM TB_TODO ;

COMMIT;

-- DATE를 자바에서 처리하는 방법 
-- java.sql.date 객체 받아오기
	--> 할 수는 있는데 쉽지 않음
-- 그래서 뭘 하느냐.. DB에서 DATE 타입을 문자열로 변환(TO_CHAR)
-- 문자열로 변환 후 JAVA에서 STRING 타입으로 받아오기

-- 할 일 목록 조회
SELECT TODO_NO, TODO_TITLE, COMPLETE,
	TO_CHAR(REG_DATE,'YYYY-MM-DD HH24:MI:SS') REG_DATE 
FROM TB_TODO 
ORDER BY TODO_NO;

-- 특정 할 일 1개 상세 조회
SELECT TODO_NO, TODO_TITLE, TODO_CONTENT, COMPLETE, 
	TO_CHAR(REG_DATE,'YYYY-MM-DD HH24:MI:SS') REG_DATE 
FROM TB_TODO 
WHERE TODO_NO = 1;

-- 완료된 할 일 개수 조회
SELECT COUNT(*)
FROM TB_TODO
WHERE COMPLETE = 'Y'
;

-- 할 일 추가하기
INSERT INTO TB_TODO
VALUES(SEQ_TODO_NO.NEXTVAL, ?, ? , DEFAULT, DEFAULT)
;

-- 특정 할 일의 완료 여부 수정
UPDATE TB_TODO
SET COMPLETE = 'Y'
WHERE TODO_NO = 1;

-- 할 일 수정
UPDATE TB_TODO SET
TODO_TITLE = ?,
TODO_CONTENT = ?
WHERE TODO_NO = ?
;

-- 할 일 삭제

DELETE FROM TB_TODO














