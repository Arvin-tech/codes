using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Pediatric
{
    public class Users
    {
        //this is a class for users who logged in
        public String Username { get; set; }
        public String Firstname { get; set; }
        public String Lastname { get; set; }
        public String Password { get; set; }
        public String Role { get; set; }
    }
}