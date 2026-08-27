# 🏋️‍♂️ Academia — Gym Management System

![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen?style=for-the-badge)
![Tech Stack](https://img.shields.io/badge/Stack-Java%20%7C%20SQL-blue?style=for-the-badge&logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/Licen%C3%A7a-MIT-green?style=for-the-badge)

*Sistema completo para gerenciamento de academias, matrículas, acompanhamento físico e fichas de treinos.*

---

## ⚡ Navegação Rápida

- [📌 Visão Geral](#-visão-geral)
- [🎯 Módulos do Sistema](#-módulos-do-sistema)
- [📊 Modelo de Dados & Regras](#-modelo-de-dados--regras)
- [📂 Estrutura do Repositório](#-estrutura-do-repositório)
- [🚀 Como Executar](#-como-executar)

---

## 📌 Visão Geral

O **Academia** é um sistema desenvolvido para otimizar a rotina administrativa e operacional de academias de ginástica e centros esportivos. 

Ele permite o controle eficiente de alunos ativos, planos de mensalidade, instrutores responsáveis e montagem de fichas de treino personalizadas, garantindo maior organização e segurança nas operações diárias.

---

## 🎯 Módulos do Sistema

| Módulo | Descrição & Funcionalidades |
| :--- | :--- |
| 👤 **Gestão de Alunos** | Cadastro completo de alunos, dados pessoais, histórico de matrículas e status financeiro. |
| 📋 **Fichas de Treino** | Montagem de rotinas de exercícios por grupo muscular (A/B/C), séries, repetições e carga. |
| 💳 **Planos & Mensalidades** | Controle de vencimentos, status de pagamento (Ativo, Pendente, Cancelado) e renovação. |
| 🏋️ **Instrutores & Avaliações** | Vínculo de instrutores com fichas de treino e registro de evolução corporal dos alunos. |

---

## 📊 Modelo de Dados & Regras

```
  +-------------------+       1:N       +-------------------+
  |      ALUNO        |---------------->|   FICHA_TREINO    |
  +-------------------+                 +-------------------+
  | - id: Long        |                 | - id: Long        |
  | - nome: String    |                 | - divisao: String |
  | - cpf: String     |                 | - validade: Date  |
  | - status: Enum    |                 +-------------------+
  +-------------------+                           | 1:N
            | 1:N                                 v
            v                           +-------------------+
  +-------------------+                 |     EXERCICIO     |
  |    MENSALIDADE    |                 +-------------------+
  +-------------------+                 | - nome: String    |
  | - valor: Double   |                 | - series: int     |
  | - vencimento: Date|                 | - repeticoes: int |
  +-------------------+                 +-------------------+
```

<details>
<summary><b>🔍 Clique para expandir as principais Regras de Negócio</b></summary>

- **Restrição de Acesso:** Alunos com mensalidades em atraso são sinalizados com status pendente.
- **Unicidade de CPF:** Não é permitido o cadastro de dois alunos ativos com o mesmo documento.
- **Validade do Treino:** Fichas de exercício possuem prazo de expiração para revisão periódica do instrutor.

</details>

---

## 📂 Estrutura do Repositório

```text
academia/
├── 📁 src/
│   ├── 📁 controllers/      # Controle de fluxo e eventos
│   ├── 📁 models/           # Entidades de domínio (Aluno, Treino, Plano)
│   ├── 📁 repository/       # Persistência e manipulação de dados
│   └── 📁 view/             # Interfaces de usuário
├── 📄 .gitignore
├── 📄 LICENSE               # Licença MIT
└── 📄 README.md             # Documentação do projeto
```

---

## 🚀 Como Executar

### 📌 Pré-requisitos
- Ambiente **Java JDK 11+** (ou ambiente de execução equivalente do projeto)
- Git instalado na máquina

### 🔧 Passos para execução

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/andrade111/academia.git](https://github.com/andrade111/academia.git)
   ```

2. **Acessar o diretório:**
   ```bash
   cd academia
   ```

3. **Compilar e executar:**
   ```bash
   # Exemplo para compilação via terminal
   javac -d bin src/**/*.java
   java -cp bin main.Main
   ```

---

<div align="center">

<sub>Desenvolvido por **[Gabriel Andrade](https://github.com/andrade111)** • Licença MIT</sub>

</div>
