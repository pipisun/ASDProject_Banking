--drop table `users`

CREATE TABLE `users` (
  `userid` int(20) UNSIGNED NOT NULL,
  `fullname` varchar(100) COLLATE utf8_bin NOT NULL,
  `gender` int(1) UNSIGNED ,
  `state` varchar(50) COLLATE utf8_bin NOT NULL  default 0,
  `city` varchar(50) COLLATE utf8_bin,
  `street` varchar(50) COLLATE utf8_bin,
  `zipcode` int(5) UNSIGNED ,
  `birthyear` int(4) UNSIGNED ,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateupdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数�?� `users`
--

INSERT INTO `users` (`userid`, `fullname`, `gender`, `state`, `city`, `street`, `zipcode`, `birthyear`, `email`, `password`, `datecreated`, `dateupdated`) VALUES
(1, 'aa', 0, 'aa', 'aa', '21', 21, 1998, 'aa', 'aa', '2017-03-18 16:32:11', '2017-03-18 16:32:11'),
(2, 'bb', 1, 'bb', 'bb', '23', 23, 1991, 'bb', 'bb', '2017-03-18 16:32:41', '2017-03-18 16:32:41'),
(3, 'cc', 1, 'cc', 'cc', '26', 24, 1992, 'cc', 'cc', '2017-03-18 16:33:11', '2017-03-18 16:33:11'),
(4, 'dd', 0, 'dd', 'dd', '59', 12, 1999, 'dd', 'dd', '2017-03-18 16:33:44', '2017-03-18 16:33:44'),
(5, 'ee', 1, 'ee', 'ee', '51', 12, 1980, 'ee', 'ee', '2017-03-18 16:34:18', '2017-03-18 16:34:18'),
(12, 'aa', 0, 'aa', 'aa', '21', 0, 0, 'aa', 'aa', '2017-03-19 16:02:50', '2017-03-19 16:02:50'),
(13, 'aa', 0, 'aa', 'aa', '21', 0, 0, 'aa', 'aa', '2017-03-19 16:03:59', '2017-03-19 16:03:59'),
(14, 'aa', 0, 'aa', 'aa', '21', 0, 0, 'aa', 'aa', '2017-03-19 16:17:26', '2017-03-19 16:17:26');

ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);
ALTER TABLE `users`
  MODIFY `userid` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
 

CREATE TABLE `permission` (
  `permissionid` int(20) UNSIGNED NOT NULL,
  `permissioncode` varchar(100) COLLATE utf8_bin NOT NULL,
  `permissionname` varchar(100) COLLATE utf8_bin NOT NULL,
  `description` varchar(100)  COLLATE utf8_bin ,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateupdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
ALTER TABLE `permission`
  ADD PRIMARY KEY (`permissionid`);
ALTER TABLE `permission`
  MODIFY `permissionid` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
 
INSERT INTO `permission` (`permissionid`, `permissioncode`, `permissionname`,`description` ) VALUES
(1, 'BankMainWindow.Menu1.Item11', 'Add Company Customer', 'Add Company Customer'),
(2, 'BankMainWindow.Menu1.Item12', 'Add Person Customer', 'Add Person Customer'),
(3, 'BankMainWindow.Menu1.Item13', 'Show Customers List', 'Show Customers List'),
(4, 'BankMainWindow.Menu2.Item21', 'Create An Account', 'Create An Account'),
(5, 'BankMainWindow.Menu2.Item22', 'Add Interest', 'Add Interest'),
(6, 'BankMainWindow.Menu2.Item23', 'Display Accounts List', 'Display Accounts List'),
(7, 'BankMainWindow.Menu3.Item31', 'Display User', 'Display User'),
(8, 'BankMainWindow.Menu3.Item32', 'Add User', 'Add User'),
(9, 'BankMainWindow.Menu3.Item33', 'Manage Permission', 'Manage Permission'),
(10, 'BankMainWindow.Menu4.Item41', 'Contents', 'Contents'),
(11, 'BankMainWindow.Menu4.Item42', 'About...', 'About...'),
(12, 'BankMainWindow.Menu4.Item43', 'Exit', 'Exit');
 
 
 
CREATE TABLE userpermission (
        userpermissionid int(20) unsigned NOT NULL AUTO_INCREMENT, 
        permissionid int(20) unsigned NOT NULL, 
        userid int(20) unsigned, 
        roleid int(20) unsigned, 
        datecreated timestamp DEFAULT CURRENT_TIMESTAMP, 
        dateupdated timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
        PRIMARY KEY (userpermissionid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into userpermission(permissionid,userid) value(1,18);
insert into userpermission(permissionid,userid) value(2,18);





  
  
 --- test for sql 
  update users set fullname='linchen', email = 'linchen@gmail.com',password='linchen'  where userid=18
  
select p.* from userpermission up left join users u on up.userid=u.userid
left join permission p on up.permissionid = p.permissionid

where up.userid =18
  
  select * from userpermission
  select * from users;
  select * from permission;
  delete   from userpermission;
  
  select * from  USERS  where 1 = 1 and zipcode=0 and password='test' and email='test@gmail.com'