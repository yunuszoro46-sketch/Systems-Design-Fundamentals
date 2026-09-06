# Databases, Disk, Memory & Persistent Storage

## 1. Databases

A **database** is a system designed to **store, organize, and retrieve data** efficiently.

At a basic level, databases perform two important operations:

- **Record data** — save information for future use.
- **Query data** — retrieve specific information when needed.

Most databases run as long-lived services and communicate with applications through **network requests**, commonly using protocols such as TCP or HTTP.

### Why persistence matters

Application data usually needs to survive:

- Power failures
- Machine crashes
- Process restarts
- Network failures

Because of this, databases generally cannot rely only on RAM. Important data is written to **persistent storage**, allowing it to remain available even after a system failure.

In large-scale systems, databases may use dedicated disks, partitions, or storage volumes so that data can potentially be recovered even when an individual machine fails.

---

## 2. Disk Storage

**Disk** generally refers to persistent storage devices such as:

- **HDD (Hard Disk Drive)**
- **SSD (Solid-State Drive)**

Data stored on disk normally survives power loss and system crashes, which makes disk a form of **non-volatile storage**.

### HDD vs SSD

| Feature | HDD | SSD |
|---|---|---|
| Technology | Magnetic disks | Flash memory |
| Access speed | Slower | Faster |
| Cost per storage | Usually cheaper | Usually more expensive |
| Best suited for | Large, infrequently accessed data | Frequently accessed data |

A useful rule in system design is to choose storage based on the **access pattern** and **cost requirements**.

For example, frequently updated or frequently requested data benefits from faster SSD storage, while archival or rarely accessed data can often be placed on cheaper HDD storage.

---

## 3. Memory (RAM)

**Memory**, commonly called **RAM (Random Access Memory)**, is temporary storage used while programs are running.

RAM provides very fast access to data, but it is **volatile**.

That means:

> Data stored only in RAM is lost when the process or system holding it stops running.

### Why use RAM?

RAM is useful when data needs to be accessed extremely quickly.

Examples include:

- Temporary variables
- In-memory caches
- Active program data
- Frequently accessed information

However, RAM alone is not suitable for storing important data that must survive a restart or failure.

---

## 4. Persistent Storage

**Persistent storage** is storage that keeps data available even after the process managing it stops.

Common examples include:

- SSDs
- HDDs
- Persistent cloud storage
- Database storage volumes

### RAM vs Persistent Storage

| Property | RAM | Persistent Storage |
|---|---|---|
| Volatile? | Yes | No |
| Data survives restart? | No | Yes |
| Speed | Very fast | Generally slower |
| Typical use | Temporary/active data | Long-term data |

---

## 5. Key Takeaways

- **Database:** A system for recording and querying data.
- **RAM:** Fast but temporary memory.
- **Disk:** Non-volatile storage such as HDDs and SSDs.
- **Persistent storage:** Keeps data even after a process or machine stops.
- **SSD:** Faster and more expensive, generally useful for frequently accessed data.
- **HDD:** Slower but typically cheaper, useful for large amounts of less frequently accessed data.
- Databases rely on persistent storage when data must **survive failures and restarts**.

### Core Concept

```text
Application
     │
     ▼
  Database
     │
     ├── RAM
     │    └── Fast, temporary data
     │
     └── Persistent Storage
          ├── SSD
          └── HDD
               └── Data survives restarts/failures
```

> **Remember:** RAM is mainly about speed; persistent storage is mainly about durability.
