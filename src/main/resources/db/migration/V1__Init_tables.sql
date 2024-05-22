create table public.link_map
(
    link_id       int primary key generated always as identity,
    original_link text not null,
    hash_link     text not null unique
)