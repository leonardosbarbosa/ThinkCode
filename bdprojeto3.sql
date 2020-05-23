-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Maio-2020 às 04:56
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdprojeto3`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `rua` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `numero` varchar(7) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `id_usuario`, `cep`, `rua`, `bairro`, `numero`, `complemento`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 2, '05750-320', 'Rua Pedro Gomes da Costa', 'Vila Praia', '46', 'Casa', NULL, NULL),
(2, 3, '05750-320', 'Rua Carum', 'Jardim das Palmas', '58', 'Casa', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `filial`
--

CREATE TABLE `filial` (
  `id_filial` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Descricao` varchar(100) DEFAULT NULL,
  `cnpj` varchar(15) DEFAULT NULL,
  `cep` int(11) NOT NULL,
  `rua` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `numero` varchar(7) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  `telefone` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `filial`
--

INSERT INTO `filial` (`id_filial`, `Nome`, `Descricao`, `cnpj`, `cep`, `rua`, `bairro`, `numero`, `complemento`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`, `telefone`) VALUES
(1, 'Matriz', 'Matriz da loja', '1565656', 5780392, 'Rua Pedro Alvares Cabral', 'Vera Cruz', '168', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Filial Jardim Sul', 'Loja filial localizada no Jardim sul', '17261661008158', 5750320, 'Giovanni Gronchi', 'VilaAndrade', '208', 'Casa', '2020-05-22', 1, NULL, NULL, 11942616650);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_venda`
--

CREATE TABLE `item_venda` (
  `id_item` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `menu`
--

CREATE TABLE `menu` (
  `id_menu` int(11) NOT NULL,
  `pagina` varchar(50) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`id_perfil`, `tipo`, `descricao`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 'DBA', 'Usuario do Banco para teste', NULL, NULL, NULL, NULL),
(2, 'Gerente', 'Usuario gerente para teste', NULL, NULL, NULL, NULL),
(3, 'Vendedor', 'Usuario para vendas', NULL, NULL, NULL, NULL),
(4, 'TI', 'Desenvolvedor', '2020-05-23', 2, NULL, NULL),
(5, 'Faxineiro', 'Faxineiro do predio', '2020-05-23', 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `permissao`
--

CREATE TABLE `permissao` (
  `id_permissao` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_filial` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `qtde` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` double NOT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `id_usuario`, `id_filial`, `tipo`, `nome`, `qtde`, `descricao`, `valor`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 2, 1, 'Rodas', 'Rodas aro 17', 4, 'Roda aro 17 importada', 40.5, NULL, NULL),
(2, 2, 1, 'Suspensao', 'uno', 4, 'Roda aro 17 importada', 40.5, NULL, NULL),
(3, 2, 2, 'Roda', 'Pneu', 2, 'Roda celta', 52.65, NULL, NULL),
(4, 2, 1, 'Suspensão', 'Amortecedor ', 5, 'suspensão Mercedes', 52.65, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `status_venda`
--

CREATE TABLE `status_venda` (
  `id_status` int(11) NOT NULL,
  `status` varchar(30) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `status_venda`
--

INSERT INTO `status_venda` (`id_status`, `status`, `descricao`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 'Finalizada', 'Venda efetuada com sucesso', NULL, NULL, NULL, NULL),
(2, 'Cancelada', 'Venda Cancelada com sucesso', NULL, NULL, NULL, NULL),
(3, 'Inciada', 'Venda Inciada com sucesso', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  `id_filial` int(11) NOT NULL,
  `cpf_cnpj` varchar(13) NOT NULL,
  `rg` varchar(9) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(250) NOT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `sexo` varchar(10) NOT NULL,
  `empresa` tinyint(1) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `id_perfil`, `id_filial`, `cpf_cnpj`, `rg`, `nome`, `email`, `senha`, `telefone`, `sexo`, `empresa`, `data_nascimento`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 1, 1, '23579852', '333355112', 'User teste', 'testeuser@gmail.com', '123456', 58133158, 'masculino', 0, '2020-05-21', NULL, NULL, NULL, NULL),
(2, 2, 2, '40608550817', '525160280', 'GUSTAVO SANTOS NASCIMENTO', 'caous.g@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 11942616650, 'Masculino', 1, '2000-04-05', '2020-05-21', 49, NULL, NULL),
(3, 1, 1, '44444444444', '658456586', 'Marisa Rozario Silva de Souza ', 'marisarozario@gmail.com', '25d55ad283aa400af464c76d713c07ad', 11969693404, 'Feminino', 1, '2000-05-28', '2020-05-21', 3, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_filial` int(11) NOT NULL,
  `cpf_cnpj` varchar(13) NOT NULL,
  `pagamento` tinyint(1) NOT NULL,
  `parcelas` int(11) NOT NULL,
  `total` double(5,2) DEFAULT NULL,
  `data` datetime NOT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL,
  `codigo_rastreio` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id_endereco`),
  ADD KEY `usuario_endereco_fk` (`id_usuario`);

--
-- Índices para tabela `filial`
--
ALTER TABLE `filial`
  ADD PRIMARY KEY (`id_filial`);

--
-- Índices para tabela `item_venda`
--
ALTER TABLE `item_venda`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `produto_item_venda_fk` (`id_produto`),
  ADD KEY `venda_item_venda_fk` (`id_venda`);

--
-- Índices para tabela `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Índices para tabela `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id_perfil`);

--
-- Índices para tabela `permissao`
--
ALTER TABLE `permissao`
  ADD PRIMARY KEY (`id_permissao`),
  ADD KEY `perfil_id_perfil_fk` (`id_perfil`),
  ADD KEY `menu_id_menu_fk` (`id_menu`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`),
  ADD KEY `Filiais_produto_fk` (`id_filial`),
  ADD KEY `usuario_produto_fk` (`id_usuario`);

--
-- Índices para tabela `status_venda`
--
ALTER TABLE `status_venda`
  ADD PRIMARY KEY (`id_status`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `Filiais_usuario_fk` (`id_filial`),
  ADD KEY `perfil_usuario_fk` (`id_perfil`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id_venda`),
  ADD KEY `Filiais_venda_fk` (`id_filial`),
  ADD KEY `status_venda_venda_fk` (`id_status`),
  ADD KEY `endereco_venda_fk` (`id_endereco`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `filial`
--
ALTER TABLE `filial`
  MODIFY `id_filial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `item_venda`
--
ALTER TABLE `item_venda`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `menu`
--
ALTER TABLE `menu`
  MODIFY `id_menu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id_perfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `permissao`
--
ALTER TABLE `permissao`
  MODIFY `id_permissao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `status_venda`
--
ALTER TABLE `status_venda`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `id_venda` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `usuario_endereco_fk` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `item_venda`
--
ALTER TABLE `item_venda`
  ADD CONSTRAINT `produto_item_venda_fk` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`),
  ADD CONSTRAINT `venda_item_venda_fk` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`);

--
-- Limitadores para a tabela `permissao`
--
ALTER TABLE `permissao`
  ADD CONSTRAINT `menu_id_menu_fk` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`),
  ADD CONSTRAINT `perfil_id_perfil_fk` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `Filiais_produto_fk` FOREIGN KEY (`id_filial`) REFERENCES `filial` (`id_filial`),
  ADD CONSTRAINT `usuario_produto_fk` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `Filiais_usuario_fk` FOREIGN KEY (`id_filial`) REFERENCES `filial` (`id_filial`),
  ADD CONSTRAINT `perfil_usuario_fk` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `Filiais_venda_fk` FOREIGN KEY (`id_filial`) REFERENCES `filial` (`id_filial`),
  ADD CONSTRAINT `endereco_venda_fk` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`),
  ADD CONSTRAINT `status_venda_venda_fk` FOREIGN KEY (`id_status`) REFERENCES `status_venda` (`id_status`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
