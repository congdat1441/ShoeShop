USE [master]
GO
/****** Object:  Database [ShoeShop]    Script Date: 12/27/2021 2:26:10 PM ******/
CREATE DATABASE [ShoeShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ShoeShop', FILENAME = N'D:\program files\SQL 2019\MSSQL15.MSSQLSERVER\MSSQL\DATA\ShoeShop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ShoeShop_log', FILENAME = N'D:\program files\SQL 2019\MSSQL15.MSSQLSERVER\MSSQL\DATA\ShoeShop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ShoeShop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ShoeShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ShoeShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ShoeShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ShoeShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ShoeShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ShoeShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [ShoeShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ShoeShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ShoeShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ShoeShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ShoeShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ShoeShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ShoeShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ShoeShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ShoeShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ShoeShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ShoeShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ShoeShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ShoeShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ShoeShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ShoeShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ShoeShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ShoeShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ShoeShop] SET RECOVERY FULL 
GO
ALTER DATABASE [ShoeShop] SET  MULTI_USER 
GO
ALTER DATABASE [ShoeShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ShoeShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ShoeShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ShoeShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ShoeShop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ShoeShop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ShoeShop', N'ON'
GO
ALTER DATABASE [ShoeShop] SET QUERY_STORE = OFF
GO
USE [ShoeShop]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 12/27/2021 2:26:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [nvarchar](50) NULL,
	[UserName] [nvarchar](50) NULL,
	[Password] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[PhoneNumber] [nvarchar](50) NULL,
	[IsAdmin] [bit] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shoe]    Script Date: 12/27/2021 2:26:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shoe](
	[ShoeID] [nvarchar](50) NOT NULL,
	[NameShoe] [nvarchar](50) NULL,
	[Count] [bigint] NULL,
	[Price] [bigint] NULL,
	[CateID] [nvarchar](50) NULL,
	[Photo] [nvarchar](50) NULL,
 CONSTRAINT [PK_Shoe] PRIMARY KEY CLUSTERED 
(
	[ShoeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 12/27/2021 2:26:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[BillID] [bigint] NOT NULL,
	[UserId] [int] NOT NULL,
	[DateBuy] [datetime] NOT NULL,
	[Bought] [bit] NULL,
	[ShoeID] [nvarchar](50) NOT NULL,
	[QuatityItem] [int] NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
	[BillID] ASC,
	[UserId] ASC,
	[ShoeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[VLS]    Script Date: 12/27/2021 2:26:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[VLS]
AS
SELECT        dbo.Account.UserId, dbo.Account.FullName, dbo.Bill.Bought, dbo.BillDetail.BillDID, dbo.BillDetail.CountBuy, dbo.Shoe.NameShoe, dbo.Shoe.Price
FROM            dbo.Account INNER JOIN
                         dbo.Bill ON dbo.Account.UserId = dbo.Bill.UserId INNER JOIN
                         dbo.BillDetail ON dbo.Bill.BillID = dbo.BillDetail.BillID INNER JOIN
                         dbo.Shoe ON dbo.BillDetail.ShoeID = dbo.Shoe.ShoeID
GO
/****** Object:  Table [dbo].[Category]    Script Date: 12/27/2021 2:26:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CateID] [nvarchar](50) NOT NULL,
	[CateName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Bill_Shoe] FOREIGN KEY([ShoeID])
REFERENCES [dbo].[Shoe] ([ShoeID])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Bill_Shoe]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Account] FOREIGN KEY([UserId])
REFERENCES [dbo].[Account] ([UserId])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Cart_Account]
GO
ALTER TABLE [dbo].[Shoe]  WITH CHECK ADD  CONSTRAINT [FK_Shoe_Category] FOREIGN KEY([CateID])
REFERENCES [dbo].[Category] ([CateID])
GO
ALTER TABLE [dbo].[Shoe] CHECK CONSTRAINT [FK_Shoe_Category]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Account"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Bill"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 136
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "BillDetail"
            Begin Extent = 
               Top = 6
               Left = 454
               Bottom = 136
               Right = 624
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Shoe"
            Begin Extent = 
               Top = 6
               Left = 662
               Bottom = 136
               Right = 832
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VLS'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VLS'
GO
USE [master]
GO
ALTER DATABASE [ShoeShop] SET  READ_WRITE 
GO
