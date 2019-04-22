# Governance Nodes Sync Service

## Introduction

This project is built for Ontology network. Anyone can use it's RESTful interface to query the information of governance nodes.

## Interface

Query candidate node's information.

- request

```bash
curl -i http://localhost:8080/v1/nodes/infoLists
```

- response

```json
{
  "code": 0,
  "msg": "Success",
  "result": [
   {
      "id": 48,
      "name": "Megrez",
      "nodeRank": 1,
      "currentStake": 8710500,
      "progress": "33.50%",
      "detailUrl": "https://explorer.ont.io/nodes/detail/0253719ac66d7cafa1fe49a64f73bd864a346da92d908c19577a003a8a4160b7fa",
      "nodeIndex": 12,
      "publicKey": "0253719ac66d7cafa1fe49a64f73bd864a346da92d908c19577a003a8a4160b7fa",
      "address": "AUy6TaM9wxTqo9T7FiaYMnDeVExhjsR1Pq",
      "status": 2,
      "initPos": 5000000,
      "totalPos": 3710500,
      "maxAuthorize": 21000000,
      "nodeProportion": "100%"
    },
    {
      "id": 49,
      "name": "Mixar",
      "nodeRank": 2,
      "currentStake": 8599500,
      "progress": "33.08%",
      "detailUrl": "https://explorer.ont.io/nodes/detail/02765d98bb092962734e365bd436bdc80c5b5991dcf22b28dbb02d3b3cf74d6444",
      "nodeIndex": 8,
      "publicKey": "02765d98bb092962734e365bd436bdc80c5b5991dcf22b28dbb02d3b3cf74d6444",
      "address": "AWWChRewNcQ5nZuh8LzF8ksqPaCW8EXPBU",
      "status": 2,
      "initPos": 5000000,
      "totalPos": 3599500,
      "maxAuthorize": 21000000,
      "nodeProportion": "100%"
    },
    {
      "id": 50,
      "name": "Dubhe",
      "nodeRank": 3,
      "currentStake": 8478000,
      "progress": "32.61%",
      "detailUrl": "https://explorer.ont.io/nodes/detail/02bcdd278a27e4969d48de95d6b7b086b65b8d1d4ff6509e7a9eab364a76115af7",
      "nodeIndex": 11,
      "publicKey": "02bcdd278a27e4969d48de95d6b7b086b65b8d1d4ff6509e7a9eab364a76115af7",
      "address": "AGqzuKoEeDfMHPEBPJVs2h2fapxDGoGtK1",
      "status": 2,
      "initPos": 5000000,
      "totalPos": 3478000,
      "maxAuthorize": 21000000,
      "nodeProportion": "100%"
    }
  ]
}
```
