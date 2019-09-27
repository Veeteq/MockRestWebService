-- Drop table

DROP TABLE REST.AGENTS;

CREATE TABLE REST.AGENTS (
    "agent_id" BIGINT NOT NULL,
    "code" BIGINT,
    "firstName" VARCHAR(255),
    "lastName" VARCHAR(255),
    "lnr" BIGINT,
    "skk" BIGINT,
    CONSTRAINT PK_AGENTS PRIMARY KEY ("agent_id")
);
CREATE UNIQUE INDEX PK_AGENTS ON REST.AGENTS ("agent_id");

-- Drop table

DROP TABLE REST.BSO;

CREATE TABLE REST.BSO (
    "bso_id" BIGINT NOT NULL,
    "number" VARCHAR(255),
    "series" VARCHAR(255),
    "status" INTEGER,
    "type" VARCHAR(255),
    "updateDate" TIMESTAMP DEFAULT CURRENT_DATE() NOT NULL,
    "agent_id" BIGINT,
    CONSTRAINT PK_BSO PRIMARY KEY ("bso_id"),
    CONSTRAINT FK_AGENTS_IDX FOREIGN KEY ("agent_id") REFERENCES REST.AGENTS("agent_id") ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX FK_AGENTS_IDX ON REST.BSO ("agent_id");
CREATE UNIQUE INDEX PK_BSO ON REST.BSO ("bso_id");

-- Drop table

DROP TABLE REST.BSO_ISSUANCES;

CREATE TABLE REST.BSO_ISSUANCES (
    "bsoissuance_id" BIGINT NOT NULL,
    "agent_id" VARBINARY(255),
    "bso_id" VARBINARY(255),
    "issue_date" TIMESTAMP,
    "status" VARCHAR(255),
    CONSTRAINT PK_BSO_ISSUANCES PRIMARY KEY ("bsoissuance_id")
);
CREATE UNIQUE INDEX PK_BSO_ISSUANCES ON REST.BSO_ISSUANCES ("bsoissuance_id");

-- Drop table

DROP TABLE REST.REQUESTS_HISTORY;

CREATE TABLE REST.REQUESTS_HISTORY (
    "history_id" BIGINT NOT NULL,
    "actionId" VARCHAR(255),
    "correlationId" VARCHAR(255),
    "disableCacheReads" BOOLEAN,
    "disableCacheWrites" BOOLEAN,
    "errorDescription" VARCHAR(255),
    "issueDate" TIMESTAMP,
    "lnr" BIGINT,
    "number" VARCHAR(255),
    "responseCode" VARCHAR(255),
    "series" VARCHAR(255),
    "skk" BIGINT,
    "type" VARCHAR(255),
    CONSTRAINT PK_REQUESTS_HISTORY PRIMARY KEY ("history_id")
);
CREATE UNIQUE INDEX PK_REQUESTS_HISTORY ON REST.REQUESTS_HISTORY ("history_id");
