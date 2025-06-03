<h1 align="center">🏦 Sistema Bancário - UnibankOne 💳</h1>

<p align="center">
  <strong>Projeto desenvolvido em Java, utilizando Programação Orientada a Objetos (POO) e interface interativa de console com o motor gráfico</strong><br>
  <strong>💡 VM ENGINE DEVELOPMENT v1.5</strong>
</p>

---

## 📘 Descrição do Projeto

O **UnibankOne** é um sistema bancário acadêmico desenvolvido para simular operações financeiras reais, como cadastro de clientes, abertura de contas, depósitos, saques, transferências e um painel administrativo completo (BackOffice), além de controle de menores de idade com autorização de responsáveis legais.

---

## 🚀 Funcionalidades

### 👤 Clientes e Contas
- Cadastro com validações de CPF e número exclusivo do cliente.
- Abertura de contas **corrente** e **poupança** com parâmetros distintos.
- Associação de múltiplas contas a um cliente.
- Suporte para **menores de idade**, exigindo termo assinado.

### 💸 Operações Financeiras
- Depósito com validação de entrada.
- Saque com verificação de saldo e limite (para conta corrente).
- Transferência entre contas com autenticação e verificação.

### 🧾 Painel Administrativo (BackOffice)
- Listagem completa de clientes e contas.
- Estatísticas do sistema (clientes, menores, contas).
- Verificação de contas com saldo zerado.
- Alteração e exclusão de contas e dados.
- Listagem de responsáveis legais.

---

## 🔐 Controle de Responsáveis Legais

O sistema implementa um controle rigoroso para menores de idade:
- CPF do responsável só pode ser vinculado a **um único menor**.
- Dados ficam registrados em `Map<String, String>` para rastreabilidade.
- Termo de autorização é impresso diretamente no console com data e nome completo.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
  
  ###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo" />
</div>

###
- **Paradigma:** Programação Orientada a Objetos
- **Interface:** Console (texto com menus estilizados)
- **Motor gráfico:** `VM Engine Development v1.5`
  
  <div align="left">
  <img src="VM%20ENGINE.png" height="100" alt="VM Engine Logo" />
</div>

- **Armazenamento:** Em memória (dados não persistentes)

---

## 🧩 Estrutura de Classes

- `Pessoa` – Classe base com atributos comuns (nome, CPF, endereço, nascimento)
- `Cliente` – Herda de Pessoa e gerencia contas
- `Conta` (abstrata) – Base para contas bancárias
- `ContaCorrente` – Conta com limite de cheque especial
- `ContaPoupanca` – Conta com taxa de juros aplicada
- `Funcionario` – Classe preparada para futuras expansões com autenticação
- `Banco` – Classe gerenciadora de clientes e contas
- `SistemaBancario` – Classe principal com menus, lógica e autenticação

---

## 🎨 Interface do Console

- Menus centralizados com molduras
- Transições com `Thread.sleep()` para experiência fluida
- Créditos, informações e ASCII Art de encerramento
- Login administrativo com autenticação (`Admin` / `1234`)

---

## 👨‍💻 Autoria

- Desenvolvedor: **Vitor Manoel Vidal Braz**  
- Curso: **Sistemas de Informação - UNIVALE**  
- Período: 3º  
- Disciplina: **Programação Orientada a Objetos (POO)**  
- Professor Orientador: **Vitor Silva Ribeiro**

---

## 🔗 Repositório e Perfil

- 🔗 GitHub: [@vitormanoelvb](https://github.com/vitormanoelvb)
- 📂 Repositório do Projeto: [UnibankOne](https://github.com/vitormanoelvb/sistema-bancario-unibankone)

---

🎮 **Conheça mais sobre o Projeto VM Engine (SkyFall)**  
📺 YouTube: [@VitorManoelVB](https://www.youtube.com/@VitorManoelVB)

###

<h2 align="left">Redes Sociais - Univale:</h2>

###

<div align="left">
  <a href="https://www.facebook.com/Univale?mibextid=ZbWKwL" target="_blank">
    <img src="https://img.shields.io/static/v1?message=Facebook&logo=facebook&label=&color=1877F2&logoColor=white&labelColor=&style=for-the-badge" height="38" alt="facebook logo"  />
  </a>
  <a href="https://x.com/UnivaleGV?t=GG3yvwT-03gOueuSgPHMkg&s=09" target="_blank">
    <img src="https://img.shields.io/static/v1?message=Twitter&logo=twitter&label=&color=1DA1F2&logoColor=white&labelColor=&style=for-the-badge" height="38" alt="twitter logo"  />
  </a>
  <a href="https://www.instagram.com/univalegv?igsh=MWk2M2JnNHYwZnp4dw==" target="_blank">
    <img src="https://img.shields.io/static/v1?message=Instagram&logo=instagram&label=&color=E4405F&logoColor=white&labelColor=&style=for-the-badge" height="38" alt="instagram logo"  />
  </a>
  <a href="https://br.linkedin.com/school/univalegv/" target="_blank">
    <img src="https://img.shields.io/static/v1?message=LinkedIn&logo=linkedin&label=&color=0077B5&logoColor=white&labelColor=&style=for-the-badge" height="38" alt="linkedin logo"  />
  </a>
  <a href="https://youtube.com/@univale?si=M-sfT4D0J5PYWvGT" target="_blank">
    <img src="https://img.shields.io/static/v1?message=Youtube&logo=youtube&label=&color=FF0000&logoColor=white&labelColor=&style=for-the-badge" height="38" alt="youtube logo"  />
  </a>
</div>

> **@vmengine2025**

## 📺 Créditos Visuais

```
 __      __ __  __     _____  __     _______ _______ __  __ 
 \ \    / /|  \/  |   / ____| \ \   / / ____|__   __|  \/  |
  \ \  / / | \  / |  | (___    \ \_/ / (___    | |  | \  / |
   \ \/ /  | |\/| |   \___ \    \   / \___ \   | |  | |\/| |
    \  /   | |  | |   ____) |    | |  ____) |  | |  | |  | |
     \/    |_|  |_|  |_____/     |_| |_____/   |_|  |_|  |_|
                        V M   S Y S T E M S                  
```

Desenvolvido com o motor gráfico exclusivo:  
**🖥️ VM ENGINE DEVELOPMENT v1.5**

<div align="left">
  <img src="VM%20ENGINE.png" height="100" alt="VM Engine V" />
</div>

---

## 📌 Observações Finais

Este sistema é acadêmico e não deve ser utilizado em ambientes produtivos. Foi elaborado para fins didáticos e desenvolvimento das habilidades em Java, POO e simulação de sistemas reais.

---

###

<div align="center"> 
  <img src="BANNER%20-%20VEW%20SOLU%C3%87%C3%95ES.png" width="100%" alt="VM ENGINE SYSTEMS" />
</div>

---
