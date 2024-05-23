import { Box, Flex, HStack, Link, IconButton, useDisclosure, Stack, Button } from "@chakra-ui/react";
import { HamburgerIcon, CloseIcon } from "@chakra-ui/icons";
import React from "react";

import { LuPiggyBank } from "react-icons/lu";

const Links = [
  { key: "1", path: "/", label: "Home" },
  { key: "2", path: "/list", label: "List" },
];

const NavLink = ({ children }) => (
  <Link
    px={2}
    py={1}
    rounded={"md"}
    _hover={{
      textDecoration: "none",
      bg: "gray.200",
    }}
    href={"#"}
  >
    {children}
  </Link>
);

export default function SimpleNavbar() {
  const { isOpen, onOpen, onClose } = useDisclosure();

  const handleClick = () => {
    window.alert(
      "Esta aplicação focada em mobile visa ser um fácil cadastro para leituras futuras. Desenvolvida por: Lucas Sigoli, João Castro e Erick Gomes"
    );
  };

  return (
    <Box bg={"gray.100"} px={4} w={"100vw"}>
      <Flex h={16} alignItems={"center"} justifyContent={"space-between"}>
        <IconButton
          size={"md"}
          icon={isOpen ? <CloseIcon /> : <HamburgerIcon />}
          aria-label={"Open Menu"}
          display={{ md: "none" }}
          onClick={isOpen ? onClose : onOpen}
        />
        <HStack spacing={8} alignItems={"center"}>
          <Box>
            <LuPiggyBank />
          </Box>
          <HStack as={"nav"} spacing={4} display={{ base: "none", md: "flex" }}>
            {Links.map((link) => (
              <Link key={link.key} to={link.path}>
                <NavLink>{link.label}</NavLink>
              </Link>
            ))}
          </HStack>
        </HStack>
        <Flex alignItems={"center"}>
          <Button className="about-us" onClick={handleClick} variant={"solid"} colorScheme={"teal"} size={"sm"} mr={4}>
            Saiba Mais
          </Button>
        </Flex>
      </Flex>

      {isOpen ? (
        <Box pb={4} display={{ md: "none" }}>
          <Stack as={"nav"} spacing={4}>
            {Links.map((link) => (
              <Link key={link.key} to={link.path}>
                <NavLink>{link.label}</NavLink>
              </Link>
            ))}
          </Stack>
        </Box>
      ) : null}
    </Box>
  );
}
