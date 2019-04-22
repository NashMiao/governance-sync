CREATE TABLE IF NOT EXISTS t_node_info
(
    id              BIGINT      NOT NULL AUTO_INCREMENT,
    name            VARCHAR(64) NOT NULL DEFAULT '',
    node_index      BIGINT      NOT NULL,
    public_key      VARCHAR(70) NOT NULL,
    address         VARCHAR(34) NOT NULL,
    status          INT         NOT NULL,
    init_pos        BIGINT      NOT NULL,
    total_pos       BIGINT      NOT NULL,
    max_authorize   VARCHAR(64) NOT NULL,
    node_proportion VARCHAR(64) NOT NULL,
    primary key (id)
);