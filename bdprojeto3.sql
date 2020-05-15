-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16-Maio-2020 às 00:03
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdprojeto3`
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `id_usuario`, `cep`, `rua`, `bairro`, `numero`, `complemento`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 1, '5780392', 'SEM RUA', 'SEM BAIRRO', '0', NULL, NULL, NULL),
(2, 5, '45345-345', 'dfvghfdgh', 'gfhgf', '44', 'fdgdf', NULL, NULL),
(3, 6, '04531-011', 'Pedroso Alvarenga', 'Itaim Bibi', '793', 'Apto 01', NULL, NULL),
(4, 7, '00453-111', 'dfgsd', 'dsrf', '3', 'dsf50', NULL, NULL),
(5, 8, '43534-534', 'dfgghdfgh', 'dfgh', '456789', 'fgf', NULL, NULL),
(6, 16, '54054-054', 'LDFKSNGDSF', 'dffgfq', '23', 'fdlkmg', NULL, NULL);

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
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `filial`
--

INSERT INTO `filial` (`id_filial`, `Nome`, `Descricao`, `cnpj`, `cep`, `rua`, `bairro`, `numero`, `complemento`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 'Matriz', 'Matriz da loja', '1565656', 5780392, 'Rua Pedro Alvares Cabral', 'Vera Cruz', '168', NULL, NULL, NULL, NULL, NULL),
(2, 'Filial Jardim Sul', 'Loja filial localizada no Jardim sul', '1565686', 5780397, 'Giovanni Gronchi', 'Vila Andrade', '208', NULL, NULL, NULL, NULL, NULL),
(3, 'Test', 'dsf', '22222222222222', 44444444, 'dsfg', 'dfg', '323', 'dfg', '2020-05-13', 1, NULL, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`id_perfil`, `tipo`, `descricao`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 'DBA', 'Usuario do Banco para teste', NULL, NULL, NULL, NULL),
(2, 'Gerente', 'Usuario gerente para teste', NULL, NULL, NULL, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `id_usuario`, `id_filial`, `tipo`, `nome`, `qtde`, `descricao`, `valor`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 1, 1, 'limpeza', 'Limpa vidro 30 ml', 8, 'limpador de vidro para automoveis', 10.2, NULL, NULL),
(2, 1, 1, 'Rodas', 'Rodas aro 17', 4, 'Roda aro 17 importada', 40.5, NULL, NULL),
(3, 1, 1, 'Carro', 'Roda', 500, 'Roda de viado', 300, NULL, NULL),
(4, 1, 1, 'Caminhão', 'Banco', 500, 'Banco para o caminhão do gutão', 200.99, NULL, NULL),
(5, 1, 1, 'Produto para teste', 'Produto Z', 5, 'dfgdfh', 500, NULL, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `senha` varchar(50) NOT NULL,
  `telefone` bigint(20) DEFAULT NULL,
  `sexo` varchar(10) NOT NULL,
  `empresa` tinyint(1) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_inclusao` date DEFAULT NULL,
  `usr_inclusao` int(11) DEFAULT NULL,
  `data_exclusao` date DEFAULT NULL,
  `usr_exclusao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `id_perfil`, `id_filial`, `cpf_cnpj`, `rg`, `nome`, `email`, `senha`, `telefone`, `sexo`, `empresa`, `data_nascimento`, `data_inclusao`, `usr_inclusao`, `data_exclusao`, `usr_exclusao`) VALUES
(1, 1, 1, '23579852', '333355112', 'Carlos Antonio Lima', 'Carlos.lima@gmail.com', '123456', 58133158, 'masculino', 0, '0000-00-00', NULL, NULL, NULL, NULL),
(2, 1, 1, '23579882', '334355112', 'Jéssica groove', 'je.groove@gmail.com', '1234567', 58133758, 'indefinido', 0, '0000-00-00', NULL, NULL, NULL, NULL),
(3, 1, 1, '23222222222', '333333333', 'Gustavo', 'gustavo@email.com', '123456', 44444444444, 'Masculino', 2, '2020-05-06', '2020-05-06', NULL, NULL, NULL),
(4, 1, 1, '44353456436', '324234234', 'Leozin', 'leo@email.com', '12345', 34244234234, 'Masculino', 2, '2020-05-06', '2020-05-06', NULL, NULL, NULL),
(5, 1, 1, '54544545544', '444444444', 'dfgdsg', 'ff', 'hjj', 45454455445, 'Masculino', 2, '2020-05-06', '2020-05-06', NULL, NULL, NULL),
(6, 1, 1, '46231805816', '548295700', 'Leonardo da Silva Barbosa', 'leonardo.sbarbosa2801@gmail.com', '123456', 11945154979, 'Masculino', 1, '2001-03-15', '2020-05-11', NULL, NULL, NULL),
(7, 1, 1, '24324242342', '222222222', 'Leonardodsaf', 'rdf', '3', 34244444444, 'Masculino', 1, '2020-05-06', '2020-05-06', NULL, NULL, NULL),
(8, 1, 1, '01010101011', '654613213', 'a', 'dsfgdsg', 'dd', 65410650145, 'Feminino', 1, '2020-05-06', '2020-05-06', NULL, NULL, NULL),
(11, 1, 1, '', '555555555', 'Guts', 'leo@email.com', '123', 22222222222, 'Masculino', 1, '2020-04-27', '2020-05-11', NULL, NULL, NULL),
(12, 1, 1, '33333333333', '333333333', 'g', 't', 't', 34455555555, 'Masculino', 1, '2020-04-27', '2020-05-11', NULL, NULL, NULL),
(13, 1, 1, '34333333333', '333333333', 'g', 'g', 'g', 66666666666, 'Masculino', 1, '2020-03-30', '2020-05-11', NULL, NULL, NULL),
(14, 1, 1, '45555555555', '444444444', 'Gutao', 'leo@email.com', '123', 11111111111, 'Masculino', 1, '2020-02-04', '2020-05-11', NULL, NULL, NULL),
(15, 1, 1, '45454541000', '121210000', 'FILHO DA PUTA', 'FUNCIONA@PORRA.COM', '23456', 11010101159, 'Masculino', 1, '2013-10-02', '2020-05-11', NULL, NULL, NULL),
(16, 1, 1, '12650505050', '444444444', 'Felippe', 'lipinho@email.com', '12345', 11111111111, 'Masculino', 1, '2000-10-09', '2020-05-15', NULL, NULL, NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id_venda`, `id_status`, `id_endereco`, `id_usuario`, `id_filial`, `cpf_cnpj`, `pagamento`, `parcelas`, `total`, `data`, `data_exclusao`, `usr_exclusao`, `codigo_rastreio`) VALUES
(1, 3, 1, 1, 1, '00000000', 1, 1, NULL, '2020-04-27 00:00:00', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id_endereco`),
  ADD KEY `usuario_endereco_fk` (`id_usuario`);

--
-- Indexes for table `filial`
--
ALTER TABLE `filial`
  ADD PRIMARY KEY (`id_filial`);

--
-- Indexes for table `item_venda`
--
ALTER TABLE `item_venda`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `produto_item_venda_fk` (`id_produto`),
  ADD KEY `venda_item_venda_fk` (`id_venda`);

--
-- Indexes for table `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id_perfil`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`),
  ADD KEY `Filiais_produto_fk` (`id_filial`),
  ADD KEY `usuario_produto_fk` (`id_usuario`);

--
-- Indexes for table `status_venda`
--
ALTER TABLE `status_venda`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `Filiais_usuario_fk` (`id_filial`),
  ADD KEY `perfil_usuario_fk` (`id_perfil`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id_venda`),
  ADD KEY `Filiais_venda_fk` (`id_filial`),
  ADD KEY `status_venda_venda_fk` (`id_status`),
  ADD KEY `endereco_venda_fk` (`id_endereco`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `filial`
--
ALTER TABLE `filial`
  MODIFY `id_filial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `item_venda`
--
ALTER TABLE `item_venda`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id_perfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `status_venda`
--
ALTER TABLE `status_venda`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
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
