-- 페이징 처리

-- 1) 페이징 적용 전
select bno, title
from board
order by bno desc;

-- 2) 페이징 적용 후
-- limit 시작 인덱스, 개수
select bno, title
from board
order by bno desc
limit 0,10;

-- 페이지의 시작 인덱스 계싼 공식을 적용
select bno, title
from board
order by bno desc
limit ((페이지번호-)*페이지당개수),패이지당개수;