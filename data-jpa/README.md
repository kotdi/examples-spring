# stream-api
Примеры использования Spring Data JPA

___

## Краткое описание что такое Spring Data JPA

## Вопрос/Ответ

### 1) Чем отличается использование limit и offset от offset и fetch?

___
Осталось разобрать:

void flush();

S saveAndFlush(S entity);

List<S/> saveAllAndFlush(Iterable<S/> entities);

R findBy(Example<S/> example, Function<FluentQuery.FetchableFluentQuery<S/>, R> queryFunction);