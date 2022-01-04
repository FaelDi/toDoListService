CREATE TABLE public.todo_list_item (
	id SERIAL NOT NULL,
	title varchar(50) unique NOT NULL,
	description varchar(50) NOT NULL,
	CONSTRAINT items_pkey PRIMARY KEY (id)
);

INSERT INTO public.todo_list_item
(title, description)
VALUES('Ir para academia', 'atividade fisica diária');
